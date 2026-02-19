package com.example.check_room.DTO;

import com.example.check_room.Entity.Attrezzatura;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AulaDTO {

    private Long id;
    private List<Attrezzatura> attrezzaturaList;
    private String nome;
    private String edificio;
    private int piano;
    private int capienza;
    private String descrizione;
    private boolean attiva;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
