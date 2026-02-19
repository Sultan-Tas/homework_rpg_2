package com.narxoz.rpg.combat.abilityIce;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class IceShield implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public IceShield(){
        this.name = "Ice Shield";
        this.damage = 0;
        this.description = "Enemy covers themselves in thick layer of ice";
        this.abilityType = AbilityType.BUFF;
    }
    public IceShield(Ability other){
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
        return new IceShield(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
