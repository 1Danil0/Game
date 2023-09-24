package com.danilermolenko.spring.game.service;


import com.danilermolenko.spring.game.dao.DAO;
import com.danilermolenko.spring.game.dto.CreatureDTO;
import com.danilermolenko.spring.game.entity.Monster;
import com.danilermolenko.spring.game.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final DAO dao;
    boolean playerIsExist = false;
    @Autowired
    public Service(DAO dao) {
        this.dao = dao;
    }
    public boolean createCreature(CreatureDTO creature){
        if(!playerIsExist){
            dao.createPlayer(creature);
            playerIsExist = true;
            return playerIsExist;
        }
        dao.createMonster(creature);
        return playerIsExist;
    }
    public List<Monster> findMonsters(){
        return dao.findMonsters();
    }
    public Player findPlayer(){
        return dao.findPlayer();
    }
    public boolean hit(int id){
        dao.hit(id);
        return dao.findPlayer().isAlive();
    }
}