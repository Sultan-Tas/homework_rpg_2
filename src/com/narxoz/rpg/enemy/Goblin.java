package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Punch;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.LootTableBasic;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Example basic enemy implementation — a simple Goblin.
 *
 * This is provided as a REFERENCE to show enemy structure.
 * Study this implementation, then create more enemies.
 *
 * Notice:
 * - Simple stats (low health, low damage)
 * - Basic constructor (only a few parameters — no Builder needed!)
 * - This is intentionally simple to contrast with DragonBoss.java
 *
 * ============================================================
 * IMPORTANT OBSERVATION:
 * ============================================================
 *
 * A Goblin is simple: name, health, damage, defense — done.
 * A regular constructor works fine here:
 *     new Goblin("Forest Goblin")
 *
 * But look at DragonBoss.java... THAT'S where Builder shines!
 * Simple objects don't need Builder. Complex objects do.
 * Knowing WHEN to use a pattern is as important as knowing HOW.
 *
 * ============================================================
 * PROTOTYPE PATTERN NOTE:
 * ============================================================
 *
 * Goblin is a GREAT candidate for Prototype pattern!
 * Imagine you need 50 goblins for a dungeon. Instead of:
 *     new Goblin("Goblin 1"), new Goblin("Goblin 2"), ...
 *
 * You can:
 *     Goblin template = new Goblin("Goblin");
 *     Enemy goblin1 = template.clone();  // Fast!
 *     Enemy goblin2 = template.clone();  // Fast!
 *
 * And for variants:
 *     Enemy elite = template.clone();
 *     // modify elite's stats to 2x
 *
 * TODO: Implement the clone() method with DEEP COPY.
 * TODO: Create similar basic enemies: Skeleton, Orc, etc.
 * TODO: Consider what needs deep vs shallow copy here.
 *   - Primitive stats (health, damage) → shallow copy is fine
 *   - Ability list → MUST be deep copied!
 *   - LootTable → MUST be deep copied!
 */
public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String element = "Basic";

    private String aiBehavior;
    private Map<Integer, Integer> phases = new HashMap<>();

    // TODO: Add more fields as needed (element, AI behavior, etc.)

    public Goblin(String name) {
        this.name = name;
        // Goblin stats: weak but fast
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
        this.abilities.add(new Punch());
        this.lootTable = new LootTableBasic();
    }
    public Goblin(String name, int health, int damage, int defense, int speed, List<Ability> abilities, LootTable lootTable, String element) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities;
        this.lootTable = lootTable;
        this.element = element;
    }

    // TODO: Implement methods from Enemy interface
    // You need to define those methods in Enemy first!

    // Example method structure:
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
        for(Ability ability : abilities) {
            System.out.println("\t[" + ability.getName() + "]");
            System.out.println("\t\t DMG:" + ability.getDamage());
            System.out.println("\t\t <" + ability.getDescription() + ">");
        }
        System.out.println("  Loot Table:");
        System.out.println("Gold: " + lootTable.getGoldDrop());
        System.out.println("EXP: " + lootTable.getExperienceDrop());
        System.out.println("Items:");
        for(String item : lootTable.getItems()) {
            System.out.println("\t" + item);
        }
    }

    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        List<Ability> copyList = new ArrayList<>();
        for(Ability ability : this.abilities) {
            copyList.add(ability.clone());
        }
        copy.abilities = copyList;
        copy.lootTable = this.lootTable.clone();
        copy.element = this.element;
        return copy;
    }

    // TODO: Add helper methods for Prototype variant creation
    // Consider methods like:
    @Override
    public void multiplyStats(double multiplier){
        this.health = (int) (this.health*multiplier);
        this.damage = (int) (this.damage*multiplier);
        this.defense = (int) (this.defense*multiplier);
        this.speed = (int) (this.speed*multiplier);
    }
    @Override
    public void addAbility(Ability ability){
        this.abilities.add(ability);
    }
    @Override
    public void addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
    }

}
