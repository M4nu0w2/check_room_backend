package com.example.check_room.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name="prenotazione")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Long idAula;
    private Long userId;

    private LocalDateTime data;
    private LocalDateTime inizio;
    private LocalDateTime fine;

    private String stato;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
