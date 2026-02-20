package com.narxoz.rpg.combat;

public class Punch implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public Punch(){
        this.name = "Punch";
        this.damage = 10;
        this.description = "The enemy hits you";
        this.abilityType = AbilityType.DAMAGE;
    }
    public Punch(Ability other){
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
        return new Punch(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
