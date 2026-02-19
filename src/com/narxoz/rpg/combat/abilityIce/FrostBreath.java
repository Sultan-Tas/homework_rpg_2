package com.narxoz.rpg.combat.abilityIce;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FrostBreath implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public FrostBreath() {
        this.name = "Frost Breath";
        this.damage = 35;
        this.description = "Ice cold liquid rains down upon foes";
        this.abilityType = AbilityType.AOE;
    }
    public FrostBreath(Ability other){
        this.name = other.getName();
        this.damage = other.getDamage();
        this.description = other.getDescription();
        this.abilityType = other.getType();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Ability clone() {
        return new FrostBreath(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
