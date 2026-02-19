package com.example.check_room.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
    private List<Attrezzatura> attrezzature;
    private String nome;
    private String edificio;
    private int piano;
    private int capienza;
    private String descrizione;
    private boolean attiva;

    @Column(name="createdAt")
    private LocalDateTime createdAt;

    @Column(name="updatedAt")
    private LocalDateTime updatedAt;

}
