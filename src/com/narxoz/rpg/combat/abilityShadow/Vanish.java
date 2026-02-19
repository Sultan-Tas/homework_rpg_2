package com.narxoz.rpg.combat.abilityShadow;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class Vanish implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public Vanish(){
        this.name = "Vanish";
        this.damage = 0;
        this.description = "Nullifies next incoming attack";
        this.abilityType = AbilityType.BUFF;
    }

    public Vanish(Ability other){
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
        return new Vanish(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
