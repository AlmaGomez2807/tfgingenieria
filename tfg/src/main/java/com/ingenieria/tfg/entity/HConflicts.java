package com.ingenieria.tfg.entity;


import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class HConflicts extends BaseScores{
       public HConflicts(User u) {
        super(u);
        u.getHConflicts().add(this);
    }

    public HConflicts(User u, Integer puntuacion, Integer aciertos, Integer fallos) {
        super(u, puntuacion, aciertos, fallos);
        u.getHConflicts().add(this);
    }
}

