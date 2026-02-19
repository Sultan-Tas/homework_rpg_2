package com.narxoz.rpg.combat.abilityShadow;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class ShadowStrike implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public ShadowStrike(){
        this.name = "Shadow Strike";
        this.damage = 20;
        this.description = "A swift strike from the shadows";
        this.abilityType = AbilityType.DAMAGE;
    }
    public ShadowStrike(Ability other){
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
        return new ShadowStrike(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
