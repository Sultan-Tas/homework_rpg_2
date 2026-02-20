package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Punch;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public Enemy createMinion(EnemyComponentFactory factory){
        return new BasicEnemyBuilder()
                .setName("Weak Minion")
                .setHealth(15)
                .setDamage(5)
                .setDefence(3)
                .setSpeed(15)
                .setAbilities(factory.createAbilities())
                .addAbility(new Punch())
                .setLootTable(factory.createLootTable())
                .setElement("dark")
                .build();
    }
    public Enemy createElite(EnemyComponentFactory factory){
        return new BasicEnemyBuilder()
                .setName("Elite Foe")
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
    public Enemy createMiniBoss(EnemyComponentFactory factory){
        return new BossEnemyBuilder()
                .setName("Mini Boss")
                .setHealth(500)
                .setDamage(20)
                .setDefence(20)
                .setSpeed(15)
                .setElement("Normal")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 500)
                .addPhase(2, 200)
                .setAI("AGGRESSIVE")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .build();
    }
    public Enemy createRaidBoss(EnemyComponentFactory factory){
        return new BossEnemyBuilder()
                .setName("Raid Boss")
                .setHealth(3000)
                .setDamage(40)
                .setDefence(30)
                .setSpeed(20)
                .setElement("Evil")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 3000)
                .addPhase(2, 1000)
                .setAI("AGGRESSIVE")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .build();
    }
}
