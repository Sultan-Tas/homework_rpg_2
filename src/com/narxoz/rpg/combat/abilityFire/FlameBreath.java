package com.narxoz.rpg.combat.abilityFire;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FlameBreath implements Ability {
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public FlameBreath(){
        this.name = "Flame Breath";
        this.damage = 50;
        this.description = "A stream of fire pours down onto foes";
        this.abilityType = AbilityType.ULTIMATE;
    }
    public FlameBreath(Ability other){
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
        return new FlameBreath(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
