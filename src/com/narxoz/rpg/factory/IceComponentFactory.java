package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.abilityIce.*;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.LootTableIce;

import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return List.of(new Blizzard(), new IceShield(), new FrostBreath());
    }

    @Override
    public LootTable createLootTable() {
        return new LootTableIce();
    }

    @Override
    public String createAIBehavior() {
        return "DEFENSIVE";
    }
}
