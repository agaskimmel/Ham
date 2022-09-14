package com.example;

import java.util.HashMap;

public class EvarHamStructure <V>{

    private HashMap<String, V> eivarim = new HashMap<>();
    private V warmestValue = null;

    public V put(String key, V value){
        V preValue = this.get(key);
        this.eivarim.put(key, value);
        return preValue;
    }

    public V remove(String key){
        V preValue = this.get(key);
        this.eivarim.remove(key);
        return preValue;
    }

    public V get(String key){
        if (this.eivarim.containsKey(key)){
            this.warmestValue = this.eivarim.get(key);
        }
        return this.eivarim.get(key);
    }

    public V getWormest(){
        return this.warmestValue;
    }

}
