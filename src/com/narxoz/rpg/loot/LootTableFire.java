package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class LootTableFire implements LootTable {
    private List<String> lootList;
    private int goldDrop;
    private int expDrop;
    private String lootInfo;

    public LootTableFire() {
        lootList = new ArrayList<String>();
        lootList.add("Lava Stone");
        lootList.add("Dragon Scale");
        lootList.add("Flame Runes");
        goldDrop = 20;
        expDrop = 15;
        lootInfo = "Fire-related drops";
    }


    public LootTableFire(LootTable other) {
        lootList = other.getItems();
        goldDrop = other.getGoldDrop();
        expDrop = other.getExperienceDrop();
        lootInfo = other.getLootInfo();
    }
    @Override
    public List<String> getItems() {
        return lootList;
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return expDrop;
    }

    @Override
    public String getLootInfo() {
        return lootInfo;
    }

    @Override
    public LootTable clone() {
        return new LootTableFire(this);
    }
}
