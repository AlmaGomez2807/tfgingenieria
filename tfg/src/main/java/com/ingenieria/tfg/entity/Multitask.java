package com.ingenieria.tfg.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Multitask extends BaseScores {
    private Integer aciertoFiguras = 0;
    private Integer falloFiguras = 0;
    private Integer aciertoOperacion = 0;
    private Integer falloOperacion = 0;
    private Integer aciertoEspacio = 0;
    private Integer falloEspacio = 0;


    public Multitask(User u) {
        super(u);
        u.getMultitask().add(this);
    }

    public Multitask(User u, Integer puntuacion, Integer aciertos, Integer fallos,
     Integer aciertoFiguras, Integer falloFiguras, Integer aciertoOperacion, Integer falloOperacion,
     Integer aciertoEspacio, Integer falloEspacio) {
        super(u, puntuacion, aciertos, fallos);
        this.aciertoFiguras = aciertoFiguras;
        this.falloFiguras = falloFiguras;
        this.aciertoOperacion = aciertoOperacion;
        this.falloOperacion = falloOperacion;
        this.aciertoEspacio = aciertoEspacio;
        this.falloEspacio = falloEspacio;
        u.getMultitask().add(this);
    }
}
