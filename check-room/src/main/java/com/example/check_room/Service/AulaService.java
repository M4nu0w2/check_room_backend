package com.example.check_room.Service;

import com.example.check_room.DTO.AttrezzaturaDTO;
import com.example.check_room.DTO.AulaDTO;
import com.example.check_room.Entity.Attrezzatura;
import com.example.check_room.Entity.Aula;
import com.example.check_room.Repository.AttrezzaturaRepository;
import com.example.check_room.Repository.AulaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AttrezzaturaRepository attrezzaturaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AulaRepository aulaRepository;

    public List<AulaDTO> getAll(){
        return aulaRepository.findAll()
                .stream()
                .map(aula -> modelMapper.map(aula, AulaDTO.class))
                .toList();
    }

    public AulaDTO getAulaById(Long id){
        Aula aula= aulaRepository.findAulaById(id);
        AulaDTO dto= modelMapper.map(aula, AulaDTO.class);
        return dto;
    }

    public AulaDTO putAula(AulaDTO dto){
        //verifico se è già presente
        boolean inserted= aulaRepository.existsAulaById(dto.getId());
        if (inserted){
            throw new RuntimeException("aula già inserita");
        }else {
            Aula aula= modelMapper.map(dto, Aula.class);
            List<Attrezzatura> attrezzature = dto.getAttrezzaturaList()
                    .stream()
                    .map(attrezzaturaDTO -> modelMapper.map(attrezzaturaDTO, Attrezzatura.class))
                    .toList();

            aula.setAttrezzature(attrezzature);

            
            aulaRepository.save(aula);
        }

        return dto;
    }

    public void deleteAula(Long id){
        Aula aula= aulaRepository.findAulaById(id);
        aulaRepository.deleteById(aula.getId());

    }
}
