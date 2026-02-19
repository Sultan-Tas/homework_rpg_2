package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.abilityFire.*;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.LootTableFire;

import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return List.of(new FireBall(), new FireShield(), new FlameBreath());
    }

    @Override
    public LootTable createLootTable() {
        return new LootTableFire();
    }

    @Override
    public String createAIBehavior() {
        return "AGGRESSIVE";
    }
}
