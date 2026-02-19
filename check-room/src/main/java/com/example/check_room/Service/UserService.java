package com.example.check_room.Service;

import com.example.check_room.DTO.UserDTO;
import com.example.check_room.Entity.User;
import com.example.check_room.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll(){
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    public UserDTO getUserById(Long id){
        User utente= userRepository.findUserById(id);
        UserDTO dto= modelMapper.map(utente, UserDTO.class);
        return dto;
    }

    public UserDTO putUser(UserDTO dto){
        //verifico se è già presente
        boolean inserted= userRepository.existsUserById(dto.getId());
        if (inserted){
            throw new RuntimeException("Utente già inserito");
        }else {
            User utente= modelMapper.map(dto, User.class);
            userRepository.save(utente);
        }

        return dto;
    }

    public void deleteUser(Long id){
        User user= userRepository.findUserById(id);
        userRepository.deleteById(user.getId());

    }
}
