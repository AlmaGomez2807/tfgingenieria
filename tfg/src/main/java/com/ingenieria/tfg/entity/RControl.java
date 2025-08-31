package com.ingenieria.tfg.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RControl extends BaseScores {
    private Integer totalAzul = 0;
    private Integer totalRojo = 0;
    public RControl(User u) {
        super(u);
        u.getRControl().add(this);
    }

    public RControl(User u, Integer puntuacion, Integer aciertos, Integer fallos) {
        super(u, puntuacion, aciertos, fallos);
        u.getRControl().add(this);
    }
}
