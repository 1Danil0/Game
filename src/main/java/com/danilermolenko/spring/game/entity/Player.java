package com.danilermolenko.spring.game.entity;

public class Player extends Creature {
    private int countOfCuring;
    public Player(int health, int minDamage, int maxDamage, int resistance){
        super(health, minDamage, maxDamage, resistance);
        countOfCuring = 0;
    }
    public double cure(){
        if(this.isAlive() && countOfCuring < 3){
            this.setCurrentHealth(this.getCurrentHealth() + 0.3 * this.getHealth());

            if(this.getCurrentHealth() > this.getHealth()){
                this.setCurrentHealth(this.getHealth());
            }
            countOfCuring++;
        }
        return this.getCurrentHealth();
    }
    public int getCountOfCuring(){
        return this.countOfCuring;
    }
}
