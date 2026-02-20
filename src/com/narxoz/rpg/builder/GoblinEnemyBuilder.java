package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class GoblinEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;
    private String element;

    @Override
    public GoblinEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setDefence(int defence) {
        this.defense = defence;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public GoblinEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public GoblinEnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public GoblinEnemyBuilder setAI(String aiBehaviour) {
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) {
        return this;
    }

    @Override
    public EnemyBuilder setHasBreathAttack(boolean breathAttack) {
        return this;
    }

    @Override
    public Goblin build() {
        if(name == null || health <= 0 || damage <= 0 || defense <= 0 || speed <= 0) {
            throw new IllegalStateException("Error in input fields");
        }
        return new Goblin(name, health, damage, defense, speed, abilities, lootTable, element);
    }
}
