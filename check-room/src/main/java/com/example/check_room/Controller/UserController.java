package com.example.check_room.Controller;

import com.example.check_room.DTO.UserDTO;
import com.example.check_room.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<UserDTO>getAllUser(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDTO putUser(@RequestBody UserDTO dto){
        return userService.putUser(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestBody UserDTO dto){
        userService.deleteUser(dto.getId());
    }
}
