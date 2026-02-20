package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.BleedingStrike;
import com.narxoz.rpg.combat.Punch;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.LootTableBasic;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

/**
 * Main demonstration class for the RPG Enemy System.
 *
 * ============================================================
 * CREATIONAL PATTERNS CAPSTONE
 * ============================================================
 *
 * This demo must showcase ALL FOUR creational design patterns
 * working together in one unified system:
 *
 *   1. ABSTRACT FACTORY — Create themed enemy component families
 *   2. BUILDER          — Construct complex enemies step-by-step
 *   3. FACTORY METHOD   — Embedded in Builder.build() and Director
 *   4. PROTOTYPE        — Clone enemies into variants efficiently
 *
 * The patterns work together in a pipeline:
 *
 *   Abstract Factory (themed components)
 *          |
 *          v
 *   Builder (assembles enemy from components)
 *          |
 *          v  <-- Factory Method: build() produces the Enemy
 *   Prototype (clones built enemy into variants)
 *
 * ============================================================
 * YOUR TASKS:
 * ============================================================
 *
 * Your Main.java should demonstrate each pattern clearly,
 * then show them working together. Follow the structure below.
 *
 * Expected output flow:
 *   Part 1: Abstract Factory creates themed components
 *   Part 2: Builder constructs complex enemies
 *   Part 3: Prototype clones enemies into variants
 *   Part 4: Full pipeline — all patterns integrated
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ============================================================
        // PART 1: ABSTRACT FACTORY PATTERN
        // ============================================================
        // TODO: Create themed component factories
        //   - FireComponentFactory
        //   - IceComponentFactory
        //   - ShadowComponentFactory
        //
        // TODO: Show that each factory creates MATCHING components
        //   EnemyComponentFactory fireFactory = new FireComponentFactory();
        //   List<Ability> fireAbilities = fireFactory.createAbilities();
        //   LootTable fireLoot = fireFactory.createLootTable();
        //   String fireAI = fireFactory.createAIBehavior();
        //
        // TODO: Display the components from each factory
        //   Show that Fire factory creates fire abilities + fire loot
        //   Show that Ice factory creates ice abilities + ice loot
        //   Show that they CANNOT be mixed (consistency guaranteed!)
        //

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        //Fire
        System.out.println("Fire Factory result:");
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        String fireAI = fireFactory.createAIBehavior();
        System.out.println("\tAbilities:");
        for(Ability abil : fireAbilities) {
            System.out.print("[" + abil.getName() + "] ");
        }
        System.out.println("\nLoot: " + fireLoot.getLootInfo());
        System.out.println("AI type: " + fireAI);
        System.out.println();

        //Ice
        System.out.println("Ice Factory result:");
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        List<Ability> iceAbilities = iceFactory.createAbilities();
        LootTable iceLoot = iceFactory.createLootTable();
        String iceAI = iceFactory.createAIBehavior();
        System.out.println("\tAbilities:");
        for(Ability abil : iceAbilities) {
            System.out.print("[" + abil.getName() + "] ");
        }
        System.out.println("\nLoot: " + iceLoot.getLootInfo());
        System.out.println("AI type: " + iceAI);
        System.out.println();

        //Shadow
        System.out.println("Shadow Factory result:");
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        List<Ability> shadowAbilities = shadowFactory.createAbilities();
        LootTable shadowLoot = shadowFactory.createLootTable();
        String shadowAI = shadowFactory.createAIBehavior();
        System.out.println("\tAbilities:");
        for(Ability abil : shadowAbilities) {
            System.out.print("[" + abil.getName() + "] ");
        }
        System.out.println("\nLoot: " + shadowLoot.getLootInfo());
        System.out.println("AI type: " + shadowAI);
        System.out.println();


        // ============================================================
        // PART 2: BUILDER PATTERN
        // ============================================================
        // TODO: Build complex enemies using your EnemyBuilder
        //
        // Build at least:
        //   - One complex boss (Dragon) using BossEnemyBuilder
        //     Use the FireComponentFactory to get themed components!
        //   - One medium enemy using BasicEnemyBuilder
        //
        // TODO: Show the fluent interface in action:
        //   Enemy dragon = new BossEnemyBuilder()
        //       .setName("Ancient Fire Dragon")
        //       .setHealth(50000)
        //       .setDamage(500)
        //       .setAbilities(fireFactory.createAbilities())
        //       .setLootTable(fireFactory.createLootTable())
        //       .addPhase(1, 50000)
        //       .addPhase(2, 30000)
        //       .addPhase(3, 15000)
        //       .build();
        //
        // TODO: Show the Director creating preset enemies:
        //   EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        //   Enemy miniBoss = director.createMiniBoss();
        //   Enemy raidBoss = director.createRaidBoss();
        //
        // Think: Where is Factory Method here? (Hint: build() IS the factory method!)
        // Think: How does the Director use Factory Method delegation?

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefence(50)
                .setSpeed(60)
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .build();

        EnemyDirector director = new EnemyDirector();
        Enemy minion = director.createMinion(fireFactory);
        Enemy raidBoss = director.createRaidBoss(iceFactory);

        dragon.displayInfo();
        minion.displayInfo();
        raidBoss.displayInfo();

        // ============================================================
        // PART 3: PROTOTYPE PATTERN
        // ============================================================
        // TODO: Create a template registry and populate it
        //   EnemyRegistry registry = new EnemyRegistry();
        //   registry.registerTemplate("goblin", baseGoblin);
        //   registry.registerTemplate("dragon", baseDragon);
        //
        // TODO: Clone enemies to create difficulty variants
        //   Enemy eliteGoblin = registry.createFromTemplate("goblin");
        //   eliteGoblin.multiplyStats(2.0);  // 2x stats
        //
        // TODO: Clone enemies to create elemental variants
        //   Enemy fireDragon = registry.createFromTemplate("dragon");
        //   fireDragon.setElement("FIRE");
        //   fireDragon.setAbilities(fireFactory.createAbilities());
        //
        // TODO: Prove deep copy works!
        //   Modify cloned enemy's abilities.
        //   Show that the original template is UNCHANGED.
        //
        // Think: What would happen with shallow copy here?

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        Enemy baseGoblin = new BasicEnemyBuilder()
                .setName("The Goblin")
                .setHealth(100)
                .setDamage(15)
                .setDefence(7)
                .setSpeed(40)
                .addAbility(new Punch())
                .setLootTable(new LootTableBasic())
                .setElement("basic").build();
        Enemy baseDragon = new BossEnemyBuilder()
                .setName("The Dragon")
                .setHealth(3000)
                .setDamage(40)
                .setDefence(30)
                .setSpeed(60)
                .setElement("basic")
                .setCanFly(true)
                .setHasBreathAttack(true).build();
        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("dragon", baseDragon);

        //Goblin variations
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2);
        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.multiplyStats(5);
        championGoblin.addAbility(new BleedingStrike());
        Enemy kingGoblin = registry.createFromTemplate("goblin");
        kingGoblin.multiplyStats(10);
        kingGoblin.addPhase(1, kingGoblin.getHealth());
        kingGoblin.addPhase(2, kingGoblin.getHealth()/2);

        //dragon variations


        // ============================================================
        // PART 4: ALL PATTERNS WORKING TOGETHER
        // ============================================================
        // TODO: Show the full pipeline
        //
        // Step 1: Abstract Factory creates Shadow components
        //   EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        //
        // Step 2: Builder assembles Demon Lord with Shadow components
        //   Enemy demonLord = new BossEnemyBuilder()
        //       .setName("Demon Lord")
        //       .setAbilities(shadowFactory.createAbilities())
        //       .setLootTable(shadowFactory.createLootTable())
        //       .build();
        //
        // Step 3: Register as Prototype template
        //   registry.registerTemplate("demon-lord", demonLord);
        //
        // Step 4: Clone variants
        //   Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        //   greaterDemon.multiplyStats(2.0);
        //
        // Display all variants showing each pattern's contribution!

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        // Your integration demonstration here...


        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
        // TODO: Print a summary showing which patterns were demonstrated
        // Example:
        // System.out.println("Abstract Factory: Themed component families (Fire, Ice, Shadow)");
        // System.out.println("Builder: Complex step-by-step enemy construction");
        // System.out.println("Factory Method: Embedded in Builder.build() and Director");
        // System.out.println("Prototype: Efficient template cloning with deep copy");

        System.out.println("\n=== Demo Complete ===");
    }

    // TODO: Add helper methods as needed
    // Consider:
    // - displayEnemyDetails(Enemy enemy)
    // - demonstrateDeepCopy(Enemy original, Enemy clone)
    // - createThemeDemo(EnemyComponentFactory factory, String themeName)
}
