package com.danilermolenko.spring.game.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Component;


public class CreatureDTO {
    private int health;
    private int minDamage;
    private int maxDamage;
    private int resistance;
    public CreatureDTO(int health, int minDamage, int maxDamage, int resistance) {
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.resistance = resistance;
    }
    public int getHealth() {
        return health;
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

    @Override
    public String toString() {
        return "CreatureDTO{" +
                "health=" + health +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", resistance=" + resistance +
                '}';
    }
}
