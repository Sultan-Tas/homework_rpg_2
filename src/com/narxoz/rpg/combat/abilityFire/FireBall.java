package com.narxoz.rpg.combat.abilityFire;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FireBall implements Ability {

    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public FireBall(){
        this.name = "Fireball";
        this.damage = 30;
        this.description = "Molten magma in the shape of a ball";
        this.abilityType = AbilityType.DAMAGE;
    }
    public FireBall(Ability other){
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
        return new FireBall(this)   ;
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
