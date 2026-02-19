package com.narxoz.rpg.combat.abilityFire;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FireShield implements Ability {
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public FireShield(){
        this.name = "Fire Shield";
        this.damage = 5;
        this.description = "Releases a surge of heat that does minor damage and reduces incoming damage";
        this.abilityType = AbilityType.BUFF;
    }
    public FireShield(Ability other){
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
        return new FireShield(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
