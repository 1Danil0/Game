package com.danilermolenko.spring.game.dao;


import com.danilermolenko.spring.game.dto.CreatureDTO;
import com.danilermolenko.spring.game.entity.Creature;
import com.danilermolenko.spring.game.entity.Monster;
import com.danilermolenko.spring.game.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class DAO {
    private Player player;
    private List<Monster> monsters;

    public void savePlayer(Player player){
        this.player = player;
    }
    public void saveMonster(Monster monster){
        if(monsters == null){
            monsters = new ArrayList<>();
        }
        monsters.add(monster);
    }
    public void deleteCreatures(){
        player = null;
        monsters = null;
    }
    public List<Monster> findMonsters(){
        return monsters;
    }
    public Player findPlayer(){
        return player;
    }
    public boolean hit(int id){
        player.hit(monsters.get(id));
        if(!monsters.get(id).isAlive()){
            monsters.remove(id);
        }
        int count = monsters.size();
        if(count != 0) {
            Random random = new Random();
            monsters.get(random.nextInt(0, count)).hit(player);
        }
        return player.isAlive();
    }
}
