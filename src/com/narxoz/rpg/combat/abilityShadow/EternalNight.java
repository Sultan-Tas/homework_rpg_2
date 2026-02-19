package com.narxoz.rpg.combat.abilityShadow;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class EternalNight implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public EternalNight(){
        this.name = "Eternal Night";
        this.damage = 60;
        this.description = "Surge of dark energy fills the area";
        this.abilityType = AbilityType.ULTIMATE;
    }
    public EternalNight(Ability other){
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
        return new EternalNight(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
