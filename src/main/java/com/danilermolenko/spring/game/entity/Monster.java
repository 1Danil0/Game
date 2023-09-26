package com.danilermolenko.spring.game.entity;

public class Monster extends Creature {

    public Monster(int health, int minDamage, int maxDamage, int resistance, boolean alive) {
        super(health, minDamage, maxDamage, resistance);
        this.setAlive(alive);
    }
}
