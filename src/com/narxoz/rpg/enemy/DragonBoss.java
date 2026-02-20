package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Example complex boss enemy — THE REASON BUILDER PATTERN EXISTS.
 *
 * ============================================================
 * READ THIS CAREFULLY — THIS IS THE CORE LEARNING MOMENT!
 * ============================================================
 *
 * Look at this constructor. REALLY look at it.
 * Count the parameters. Imagine using it in Main.java.
 * Imagine a teammate trying to understand what each parameter means.
 *
 * This is called the "Telescoping Constructor" anti-pattern.
 * It's the #1 problem that the Builder pattern solves.
 *
 * YOUR MISSION:
 * After studying this horror, you will create an EnemyBuilder
 * that constructs DragonBoss (and other complex enemies)
 * step-by-step, with clear and readable code.
 *
 * Compare:
 *
 *   BEFORE (Telescoping Constructor — current code):
 *   new DragonBoss("Fire Dragon", 50000, 500, 200, 50, "FIRE",
 *       abilities, 30000, 15000, 5000, loot, "AGGRESSIVE",
 *       true, true, 20);
 *   // What does 'true, true, 20' mean? Nobody knows!
 *
 *   AFTER (Builder Pattern — your implementation):
 *   new BossEnemyBuilder()
 *       .setName("Fire Dragon")
 *       .setHealth(50000)
 *       .setDamage(500)
 *       .setDefense(200)
 *       .setSpeed(50)
 *       .setElement("FIRE")
 *       .addAbility(new FlameBreath())
 *       .addAbility(new WingBuffet())
 *       .addPhase(1, 50000)
 *       .addPhase(2, 30000)
 *       .addPhase(3, 15000)
 *       .setLootTable(fireLoot)
 *       .setAI("AGGRESSIVE")
 *       .build();
 *   // Every parameter is labeled! Readable! Maintainable!
 *
 * ============================================================
 * TODO: After implementing your Builder, REFACTOR this class!
 * ============================================================
 * - Remove (or simplify) the telescoping constructor
 * - Make DragonBoss constructable ONLY through a Builder
 * - Make the built DragonBoss IMMUTABLE (no setters!)
 * - The Builder handles all the complexity
 */
public class DragonBoss implements Enemy {

    // --- Basic Stats ---
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private List<Ability> abilities = new ArrayList<>();

    // --- Boss Phases (health thresholds that trigger behavior changes) ---
    // Phase number -> health threshold at which this phase activates
    private Map<Integer, Integer> phases = new HashMap<>();

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;

    /**
     * After you implement your Builder, this constructor should be
     * either simplified (package-private, called only by Builder)
     * or replaced entirely.
     */
    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element,
                      List<Ability> abilities,
                      Map<Integer, Integer> phases,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.putAll(phases);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
    }
    private DragonBoss(){}

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
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        //abilities
        for(Ability ability : abilities) {
            System.out.println("\t[" + ability.getName() + "]");
            System.out.println("\t\t DMG: " + ability.getDamage());
            System.out.println("\t\t <" + ability.getDescription() + ">");
        }
        //phases
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey()
                    + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly
                + " | Breath Attack: " + hasBreathAttack);
        //loot
        System.out.println("  Loot Table:");
        System.out.println("Gold: " + lootTable.getGoldDrop());
        System.out.println("EXP: " + lootTable.getExperienceDrop());
        System.out.println("Items:");
        for(String item : lootTable.getItems()) {
            System.out.println("\t" + item);
        }
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = new DragonBoss();
        copy.name = this.name;
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        List<Ability> copyList = new ArrayList<>();
        for(Ability ability : this.abilities) {
            copyList.add(ability.clone());
        }
        copy.abilities = copyList;
        copy.phases = new HashMap<>();
        copy.phases.putAll(this.phases);
        copy.aiBehavior = this.aiBehavior;
        copy.lootTable = this.lootTable.clone();
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.canFly = this.canFly;
        return null;
    }

    // TODO: Implement clone() for Prototype pattern
    // DragonBoss has MANY fields that need deep copying:
    //   - abilities (List<Ability>) → deep copy each ability
    //   - phases (Map<Integer, Integer>) → copy the map
    //   - lootTable → deep copy
    //   - primitive fields → direct copy
    //
    // This is more complex than Goblin.clone()!
    // That's the challenge of Prototype with complex objects.

    // TODO: Add helper methods for variant creation
    public void setElement(String element){
        this.element = element;
    }
    public void setAbilities(List<Ability> abilities){
        this.abilities.addAll(abilities);
    };
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
