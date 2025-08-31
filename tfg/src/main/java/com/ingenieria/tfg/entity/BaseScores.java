package com.ingenieria.tfg.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseScores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer puntuacion = 0;
    private Integer fallos = 0;
    private Integer aciertos = 0;

    @ManyToOne
    private User user;

    public BaseScores (User u){
        this.user = u;
    }
    public BaseScores (User u, Integer puntuacion, Integer aciertos, Integer fallos){
        this.user = u;
        this.puntuacion = puntuacion;
        this.aciertos = aciertos;
        this.fallos = fallos;
    }
}

