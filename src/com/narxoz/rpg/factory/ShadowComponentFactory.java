package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.abilityShadow.*;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.LootTableShadow;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return List.of(new EternalNight(), new ShadowStrike(), new Vanish());
    }

    @Override
    public LootTable createLootTable() {
        return new LootTableShadow();
    }

    @Override
    public String createAIBehavior() {
        return "TACTICAL";
    }
}
