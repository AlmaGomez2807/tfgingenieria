package com.ingenieria.tfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ingenieria.tfg.entity.Coordinate;
import com.ingenieria.tfg.entity.Figures;
import com.ingenieria.tfg.entity.HConflicts;
import com.ingenieria.tfg.entity.Multitask;
import com.ingenieria.tfg.entity.RControl;
import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;

import jakarta.transaction.Transactional;

@Component
public class DatabasePopulator implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(userService.findByUsername("test1") == null){
            generarDatos(new User("Test1"), 0);
            generarDatos(new User("Test2"), 20);
        }
        
    }

    private void generarDatos(User u, Integer entropia){
        new Coordinate(u, 100 - entropia, 5, 5);
        new Coordinate(u, 120 - entropia, 6, 4);
        new Coordinate(u, 140 - entropia, 7, 3);
        new Coordinate(u, 160 - entropia, 8, 2);
        new Coordinate(u, 180 - entropia, 9, 1);
        u.setMaxCoordinate(180 - entropia);

        new Figures(u, 80 - entropia, 4, 5, 2, 3, 2, 5);
        new Figures(u, 100 - entropia, 5, 4, 3, 2, 3, 4);
        new Figures(u, 120 - entropia, 6, 3, 4, 1, 4, 3);
        new Figures(u, 140 - entropia, 7, 2, 5, 0, 5, 2);
        new Figures(u, 160 - entropia, 8, 1, 6, 0, 6, 1);
        u.setMaxFigures(160 - entropia);

        new HConflicts(u, 100 - entropia, 5, 5);
        new HConflicts(u, 120 - entropia, 6, 4);
        new HConflicts(u, 140 - entropia, 7, 3);
        new HConflicts(u, 160 - entropia, 8, 2);
        new HConflicts(u, 180 - entropia, 9, 1);
        u.setMaxHConflicts(180 - entropia);

        new Multitask(u, 80 - entropia, 4, 5, 2, 3, 2, 5, 2, 5);
        new Multitask(u, 100 - entropia, 5, 4, 3, 2, 3, 4, 3, 4);
        new Multitask(u, 120 - entropia, 6, 3, 4, 1, 4, 3, 4, 3);
        new Multitask(u, 140 - entropia, 7, 2, 5, 0, 5, 2, 5, 2);
        new Multitask(u, 160 - entropia, 8, 1, 6, 0, 6, 1, 6, 1);
        u.setMaxMultitask(160 - entropia);

        new RControl(u, 100 - entropia, 5, 5);
        new RControl(u, 120 - entropia, 6, 4);
        new RControl(u, 140 - entropia, 7, 3);
        new RControl(u, 160 - entropia, 8, 2);
        new RControl(u, 180 - entropia, 9, 1);
        u.setMaxRControl(180 - entropia);

        userService.save(u);
    }
}
