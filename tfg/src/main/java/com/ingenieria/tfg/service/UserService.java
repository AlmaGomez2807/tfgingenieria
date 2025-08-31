package com.ingenieria.tfg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenieria.tfg.dto.Puntos;
import com.ingenieria.tfg.entity.BaseScores;
import com.ingenieria.tfg.entity.Coordinate;
import com.ingenieria.tfg.entity.Figures;
import com.ingenieria.tfg.entity.HConflicts;
import com.ingenieria.tfg.entity.Multitask;
import com.ingenieria.tfg.entity.RControl;
import com.ingenieria.tfg.entity.User;
import com.ingenieria.tfg.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        User u = userRepository.findByUsername(username);
        return u;
    }
    public void setAvatar (User u, Boolean b) {
        u.setAvatar(b);
        userRepository.save(u);
    }
    public void save (String u) {
        userRepository.save(new User(u));
    }
    public void save (User u) {
        userRepository.save(u);
    }
    public void saveGeneral(User u, BaseScores b, Integer score, Integer aciertos, Integer fallos) {
        if (b.getPuntuacion() < score)
            b.setPuntuacion(score);

        b.setAciertos(aciertos + b.getAciertos());
        b.setFallos(fallos + b.getFallos());
    }

    public void saveCoordinate(User u, Puntos data) {
        Coordinate c = new Coordinate(u);
        saveGeneral(u, c, data.getScore(), data.getAciertos(), data.getFallos());
        if(u.getMaxCoordinate()<data.getScore())
            u.setMaxCoordinate(data.getScore());
        userRepository.save(u);
    }

    public void saveFigures(User u, Puntos data) {
        Figures f = new Figures(u);
        saveGeneral(u, f, data.getScore(), data.getAciertos(), data.getFallos());
        f.setAciertoColor(f.getAciertoColor() + data.getAciertoColor());
        f.setFalloColor(f.getFalloColor() + data.getFalloColor());
        f.setAciertoFigura(f.getAciertoFigura() + data.getAciertoFigura());
        f.setFalloFigura(f.getFalloFigura() + data.getFalloFigura());
        if(u.getMaxFigures()<data.getScore())
            u.setMaxFigures(data.getScore());
        userRepository.save(u);
    }

    public void saveHConflicts(User u, Puntos data) {
        HConflicts hc = new HConflicts(u);
        saveGeneral(u, hc, data.getScore(), data.getAciertos(), data.getFallos());

        if(u.getMaxHConflicts()<data.getScore())
            u.setMaxHConflicts(data.getScore());
        userRepository.save(u);
    }

    public void saveMultitask(User u, Puntos data) {
        Multitask m = new Multitask(u);
        saveGeneral(u, m, data.getScore(), data.getAciertos(), data.getFallos());
        m.setAciertoFiguras(data.getAciertoFiguras());
        m.setFalloFiguras(data.getFalloFiguras());
        m.setAciertoOperacion(data.getAciertoOperacion());
        m.setFalloOperacion(data.getFalloOperacion());
        m.setAciertoEspacio(data.getAciertoEspacio());
        m.setFalloEspacio(data.getFalloEspacio());
        if(u.getMaxMultitask()<data.getScore())
            u.setMaxMultitask(data.getScore());
        userRepository.save(u);
    }
    
    public void saveRControl(User u, Puntos data) {
        RControl f = new RControl(u); 
        saveGeneral(u, f, data.getScore(), data.getAciertos(), data.getFallos());
        f.setTotalAzul(data.getTotalAzul()+f.getTotalAzul());
        f.setTotalRojo(data.getTotalRojo()+f.getTotalRojo());
        if(u.getMaxRControl()<data.getScore())
            u.setMaxRControl(data.getScore());
        userRepository.save(u);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void delete(String u){
        userRepository.delete(userRepository.findByUsername(u));
    }

}
