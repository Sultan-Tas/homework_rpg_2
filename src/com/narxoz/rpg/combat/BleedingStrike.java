package com.narxoz.rpg.combat;

public class BleedingStrike implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType abilityType;

    public BleedingStrike(){
        this.name = "Bleeding Strike";
        this.damage = 40;
        this.description = "Slash opens heavy wound";
        this.abilityType = AbilityType.DAMAGE;
    }
    public BleedingStrike(Ability other){
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
        return new BleedingStrike(this);
    }

    @Override
    public AbilityType getType() {
        return this.abilityType;
    }
}
