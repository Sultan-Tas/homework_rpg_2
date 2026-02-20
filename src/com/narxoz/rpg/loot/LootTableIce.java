package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class LootTableIce implements LootTable {
    private List<String> lootList;
    private int goldDrop;
    private int expDrop;
    private String lootInfo;

    public LootTableIce() {
        lootList = new ArrayList<String>();
        lootList.add("Six-phase Ice");
        lootList.add("Frost Scale");
        lootList.add("Solid Nitrogen");
        goldDrop = 25;
        expDrop = 20;
        lootInfo = "Ice-themed drops";
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
        LootTableIce copy = new LootTableIce();
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
