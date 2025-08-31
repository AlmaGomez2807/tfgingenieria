package com.ingenieria.tfg.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Coordinate extends BaseScores {
    public Coordinate(User u) {
        super(u);
        u.getCoordinate().add(this);
    }
    public Coordinate(User u, Integer puntuacion, Integer aciertos, Integer fallos) {
        super(u, puntuacion, aciertos, fallos);
        u.getCoordinate().add(this);
    }
}

