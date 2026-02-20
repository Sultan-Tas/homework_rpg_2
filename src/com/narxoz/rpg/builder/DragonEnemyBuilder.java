package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.Map;

public class DragonEnemyBuilder implements EnemyBuilder{
    // --- Basic Stats ---
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private List<Ability> abilities;

    // --- Boss Phases (health thresholds that trigger behavior changes) ---
    // Phase number -> health threshold at which this phase activates
    private Map<Integer, Integer> phases;
    private int phase1Threshold;
    private int phase2Threshold;

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;


    @Override
    public DragonEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public DragonEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public DragonEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public DragonEnemyBuilder setDefence(int defence) {
        this.defense = defence;
        return this;
    }

    @Override
    public DragonEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public DragonEnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public DragonEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public DragonEnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    @Override
    public DragonEnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public DragonEnemyBuilder setAI(String aiBehaviour) {
        this.aiBehavior = aiBehaviour;
        return this;
    }

    public DragonEnemyBuilder setPhase1Threshold(int threshold) {
        this.phase1Threshold = threshold;
        return this;
    }

    public DragonEnemyBuilder setPhase2Threshold(int threshold) {
        this.phase2Threshold = threshold;
        return this;
    }
    public DragonEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public DragonEnemyBuilder setHasBreathAttack(boolean breathAttack) {
        this.hasBreathAttack = breathAttack;
        return this;
    }
    @Override
    public DragonBoss build() {
        if(name == null || health <= 0 || damage <= 0 || defense <= 0 || speed <= 0) {
            throw new IllegalStateException("Error in input fields");
        }
        return new DragonBoss(name,
                health,
                damage,
                defense,
                speed,
                element,
                abilities,
                phase1Threshold,
                phase2Threshold,
                lootTable,
                aiBehavior,
                canFly,
                hasBreathAttack);
    }
}
