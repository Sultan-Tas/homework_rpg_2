package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder{
    // --- Basic Stats ---
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private List<Ability> abilities = new ArrayList<Ability>();

    // --- Boss Phases (health thresholds that trigger behavior changes) ---
    // Phase number -> health threshold at which this phase activates
    private Map<Integer, Integer> phases = new HashMap<Integer, Integer>();

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;


    @Override
    public BossEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BossEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public BossEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public BossEnemyBuilder setDefence(int defence) {
        this.defense = defence;
        return this;
    }

    @Override
    public BossEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BossEnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public BossEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public BossEnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.addAll(abilities);
        return this;
    }

    @Override
    public BossEnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public BossEnemyBuilder setAI(String aiBehaviour) {
        this.aiBehavior = aiBehaviour;
        return this;
    }

    @Override
    public BossEnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean breathAttack) {
        this.hasBreathAttack = breathAttack;
        return this;
    }
    @Override
    public DragonBoss build() {

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
        return new DragonBoss(name,
                health,
                damage,
                defense,
                speed,
                element,
                abilities,
                phases,
                lootTable,
                aiBehavior,
                canFly,
                hasBreathAttack);
    }
}
