package com.example.check_room.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name="aula")
@Entity
@Data
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "aula_attrezzatura",
            joinColumns = @JoinColumn(name = "idAula"),
            inverseJoinColumns = @JoinColumn(name = "idAttrezzatura")
    )
    private Set<Attrezzatura> attrezzature = new HashSet<>();
    private String nome;
    private String edificio;
    private int piano;
    private int capienza;
    private String descrizione;
    private boolean attiva;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
