package com.example.check_room.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String ruolo;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
