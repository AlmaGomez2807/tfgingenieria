package com.ingenieria.tfg.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Figures extends BaseScores {
    private Integer aciertoColor = 0;
    private Integer falloColor = 0;
    private Integer aciertoFigura = 0;
    private Integer falloFigura = 0;
    public Figures(User u) {
        super(u);
        u.getFigures().add(this);
    }
    public Figures(User u, Integer puntuacion, Integer aciertos, Integer fallos,
     Integer aciertoColor, Integer falloColor, Integer aciertoFigura, Integer falloFigura) {
        super(u, puntuacion, aciertos, fallos);
        this.aciertoColor = aciertoColor;
        this.falloColor = falloColor;
        this.aciertoFigura = falloFigura;
        this.falloFigura = falloFigura;
        u.getFigures().add(this);
    }
}
