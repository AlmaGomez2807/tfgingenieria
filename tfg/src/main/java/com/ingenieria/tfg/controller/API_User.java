package com.ingenieria.tfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingenieria.tfg.service.UserService;

@RestController
@RequestMapping("/user")
public class API_User {
    @Autowired
    private  UserService userService;

    @DeleteMapping("/eliminar/{username}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String username) {
        userService.delete(username);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
    @PutMapping("/avatar/{username}/{id}")
    public ResponseEntity<String> cambiarAvatar(@PathVariable String username, @PathVariable Boolean id) {
        userService.setAvatar(userService.findByUsername(username), id);
        return ResponseEntity.ok("Avatar modificado");
    }
}
