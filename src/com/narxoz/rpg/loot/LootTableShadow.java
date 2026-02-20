package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class LootTableShadow implements LootTable {
    private List<String> lootList;
    private int goldDrop;
    private int expDrop;
    private String lootInfo;

    public LootTableShadow() {
        lootList = new ArrayList<String>();
        lootList.add("Shadow Gem");
        lootList.add("Dark Essence");
        lootList.add("Shadow Runes");
        goldDrop = 40;
        expDrop = 30;
        lootInfo = "Shadow-related drops";
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
        LootTableShadow copy = new LootTableShadow();
        copy.goldDrop = this.goldDrop;
        copy.expDrop = this.expDrop;
        copy.lootInfo = this.lootInfo;

        copy.lootList = new ArrayList<String>();
        for(String s : lootList){
            copy.lootList.add(s);
        }
        return copy;
    }
}
