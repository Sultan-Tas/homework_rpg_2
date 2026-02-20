package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities = new ArrayList<Ability>();
    private LootTable lootTable;
    private String element;

    private String aiBehavior;
    private Map<Integer, Integer> phases = new HashMap<Integer, Integer>();


    @Override
    public BasicEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BasicEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public BasicEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public BasicEnemyBuilder setDefence(int defence) {
        this.defense = defence;
        return this;
    }

    @Override
    public BasicEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BasicEnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public BasicEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public BasicEnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.addAll(abilities);
        return this;
    }

    @Override
    public BasicEnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public BasicEnemyBuilder setAI(String aiBehaviour) {
        this.aiBehavior = aiBehaviour;
        return this;
    }

    @Override
    public BasicEnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public BasicEnemyBuilder setCanFly(boolean canFly) {
        return this;
    }

    @Override
    public BasicEnemyBuilder setHasBreathAttack(boolean breathAttack) {
        return this;
    }

    @Override
    public Goblin build() {
        if(name == null) {
            throw new IllegalStateException("Name cannot be null");
        }
        if(health <= 0){
            throw new IllegalStateException("Health must be greater than 0");
        }
        if(damage <= 0){
            throw new IllegalStateException("Damage must be greater than 0");
        }
        if(defense <= 0){
            throw new IllegalStateException("Defense must be greater than 0");
        }
        if(speed <= 0){
            throw new IllegalStateException("Speed must be greater than 0");
        }
        return new Goblin(name, health, damage, defense, speed, abilities, lootTable, element);
    }
}
