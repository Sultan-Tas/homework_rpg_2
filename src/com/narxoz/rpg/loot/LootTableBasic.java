package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class LootTableBasic implements LootTable {
    private List<String> lootList;
    private int goldDrop;
    private int expDrop;
    private String lootInfo;

    public LootTableBasic() {
        lootList = new ArrayList<String>();
        lootList.add("Monster meat");
        goldDrop = 5;
        expDrop = 3;
        lootInfo = "Basic drops";
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
        LootTableBasic copy = new LootTableBasic();
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
