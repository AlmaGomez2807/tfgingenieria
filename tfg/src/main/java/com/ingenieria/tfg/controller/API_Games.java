package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingenieria.tfg.dto.Puntos;
import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.service.UserService;



@RestController
@RequestMapping("/games")
public class API_Games {
    @Autowired
    private  UserService userService;

    @PostMapping("/{type}")
    public ResponseEntity<Puntos> puntosCoordinate(@PathVariable String type, @RequestBody Puntos data) {
        User u = userService.findByUsername(data.getUsername());
        //Determina qué juego se tiene que actualizar
        switch (type) {
            case "coordinate":
                userService.saveCoordinate(u, data);
                break;
            case "figures":
                userService.saveFigures(u, data);
                break;
            case "headingconflicts":
                userService.saveHConflicts(u, data);
                break;
            case "rcontrol":
                userService.saveRControl(u, data);
                break;
            case "multitask":
                userService.saveMultitask(u, data);
                break;
            
            default:
                throw new IllegalArgumentException("Tipo no válido: " + type);
        };

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    /*

    @GetMapping("/puntuaciones")
    public ResponseEntity<User> getPuntuaciones(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    String username = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
                break;
            }
        }
    }
    if (username == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    User u = userService.findByUsername(username);
    if (u == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(u);
    }
    */
}
