package com.ingenieria.tfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Puntos {
    private String username;
    private Integer score;
    private Integer aciertos;
    private Integer fallos;
    private Integer totalAzul;
    private Integer totalRojo;

    private Integer aciertoFiguras;
    private Integer falloFiguras;
    private Integer aciertoOperacion;
    private Integer falloOperacion;
    private Integer aciertoEspacio;
    private Integer falloEspacio;

    private Integer aciertoColor;
    private Integer falloColor;
    private Integer aciertoFigura;
    private Integer falloFigura;
}
