package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template){
        templates.put(key, template);
    }
    public Enemy createFromTemplate(String key){
        return templates.get(key).clone();
    }
    public void listTemplates(){
        templates.forEach((k,v)->{
            System.out.println("Key: " + k + ", EnemyTemplate: " + v);
        });
    }
}
