package com.example.check_room.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Table(name="attrezzatura")
@Entity
@Data

public class Attrezzatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @ManyToMany(mappedBy = "attrezzature")
    private Set<Aula> aule = new HashSet<>();
}
