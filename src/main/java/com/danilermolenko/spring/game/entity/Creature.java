package com.danilermolenko.spring.game.entity;

import java.util.Random;

public abstract class Creature {
    private final int minDamage;
    private final int maxDamage;
    private final int resistance;
    private int health;
    private double currentHealth;
    private boolean isAlive;

    public Creature(int health, int minDamage, int maxDamage, int resistance){
//        if(minDamage <= 0 || minDamage > 30 || maxDamage > 30 || maxDamage <= 0 || minDamage > maxDamage){
//            throw new IllegalStateException("damage should be from N to M");
//        }
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.resistance = resistance;
        currentHealth = health;
        isAlive = true;
    }

    public boolean hit(Creature creature){
        boolean isHitSuccessful = false;
        if(this.isAlive){
            int modificator = this.maxDamage - (creature.resistance + 1);
            modificator = modificator <= 0 ? 1 : modificator;
            for (int i = 0; i < modificator; i++){
                Random random = new Random();
                if(random.nextInt(1, 7) >= 5){
                    isHitSuccessful = true;
                    creature.currentHealth -= random.nextInt(this.minDamage, this.maxDamage + 1);
                    break;
                }
            }
            if(creature.currentHealth <= 0){
                creature.isAlive = false;
            }
        }
        return isHitSuccessful;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", resistance=" + resistance +
                ", health=" + health +
                ", currentHealth=" + currentHealth +
                ", isAlive=" + isAlive +
                '}';
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getResistance() {
        return resistance;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
