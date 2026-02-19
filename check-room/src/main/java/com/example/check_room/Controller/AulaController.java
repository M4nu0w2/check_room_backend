package com.example.check_room.Controller;

import com.example.check_room.DTO.AulaDTO;
import com.example.check_room.Service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula")
@CrossOrigin(origins = "http://localhost:4200")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    private List<AulaDTO> getAllAula(){
        return aulaService.getAll();
    }

    @GetMapping("/{id}")
    public AulaDTO getAulaById(@PathVariable Long id){
        return aulaService.getAulaById(id);
    }

    @PutMapping
    public AulaDTO putAula(@RequestBody AulaDTO dto){
        return aulaService.putAula(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@RequestBody AulaDTO dto){
        aulaService.deleteAula(dto.getId());
    }
}
