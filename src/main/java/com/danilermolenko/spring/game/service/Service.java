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
    @Autowired
    public Service(DAO dao) {
        this.dao = dao;
    }
    public void createCreature(CreatureDTO creature){
        if(dao.findPlayer() == null){
            Player player = new Player(creature.getHealth(), creature.getMinDamage(),
                    creature.getMaxDamage(), creature.getResistance(), true);
            dao.savePlayer(player);
            return;
        }
        Monster monster = new Monster(creature.getHealth(), creature.getMinDamage(),
                creature.getMaxDamage(), creature.getResistance(), true);
        dao.saveMonster(monster);
    }
    public void deleteCreatures(){
        dao.deleteCreatures();
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