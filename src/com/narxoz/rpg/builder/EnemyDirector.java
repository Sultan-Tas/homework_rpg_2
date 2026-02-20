package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Punch;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.builder.*;

public class EnemyDirector {
    private EnemyBuilder builder;

    public Enemy createMinion(GoblinEnemyBuilder builder, EnemyComponentFactory factory){
        return builder
                .setName("Weak Minion")
                .setHealth(15)
                .setDamage(5)
                .setDefence(3)
                .setSpeed(15)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setElement("dark")
                .build();
    }
    public Enemy createElite(GoblinEnemyBuilder builder, EnemyComponentFactory factory){
        return builder
                .setName("Elite Goblin")
                .setHealth(160)
                .setDamage(16)
                .setDefence(15)
                .setSpeed(10)
                .setAbilities(factory.createAbilities())
                .addAbility(new Punch())
                .setLootTable(factory.createLootTable())
                .setElement("Heavy")
                .build();
    }
    public Enemy createMiniBoss(DragonEnemyBuilder builder, EnemyComponentFactory factory){
        return builder
                .setName("Mini Boss")
                .setHealth(500)
                .setDamage(20)
                .setDefence(20)
                .setSpeed(15)
                .setElement("Normal")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setPhase1Threshold(500)
                .setPhase2Threshold(200)
                .setAI("AGGRESSIVE")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .build();
    }
    public Enemy createRaidBoss(DragonEnemyBuilder builder, EnemyComponentFactory factory){
        return builder
                .setName("Raid Boss")
                .setHealth(3000)
                .setDamage(40)
                .setDefence(30)
                .setSpeed(20)
                .setElement("Evil")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setPhase1Threshold(3000)
                .setPhase2Threshold(1000)
                .setAI("AGGRESSIVE")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .build();
    }
}
