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

    public RControl(User u, Integer puntuacion, Integer aciertos, Integer fallos, Integer totalAzul, Integer totalRojo) {
        super(u, puntuacion, aciertos, fallos);
        this.totalAzul = totalAzul;
        this.totalRojo = totalRojo;
        u.getRControl().add(this);
    }
}
