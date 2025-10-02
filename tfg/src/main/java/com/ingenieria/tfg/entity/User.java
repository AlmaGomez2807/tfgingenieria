package com.ingenieria.tfg.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(unique = true)
    private String username;
    private Integer avatar = 0; //false si niño, true si niña

    //Puntuaciones
    @OneToMany(cascade = CascadeType.ALL)
    private List<Coordinate> Coordinate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HConflicts> HConflicts;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RControl> RControl;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Multitask> Multitask;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Figures> Figures;

    //Max de puntuaciones
    private Integer maxCoordinate = 0;
    private Integer maxHConflicts = 0;
    private Integer maxRControl = 0;
    private Integer maxMultitask = 0;
    private Integer maxFigures = 0;
    private Integer totalPuntos = 0;

    public User (String username){
        this.username = username;
        this.Coordinate = new ArrayList<>();
        this.Figures = new ArrayList<>();
        this.HConflicts = new ArrayList<>();
        this.Multitask = new ArrayList<>();
        this.RControl = new ArrayList<>();
    }

}
