package com.example.check_room.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;

    private String nome;
    private String cognome;
    private String email;


    private String password;
    private String ruolo;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
