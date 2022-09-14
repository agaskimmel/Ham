package com.example;

import java.util.HashMap;

public class EvarHamStructure <V>{

    private HashMap<String, V> eivarim = new HashMap<>();
    private V warmestValue = null;


    public V put(String key, V value){
        V preValue = this.get(key);
        if (this.eivarim.containsKey(key)){
            this.warmestValue = value;
        }
        this.eivarim.put(key, value);

        return preValue;
    }

    public V remove(String key){
        V preValue = this.get(key);
        if (this.eivarim.containsKey(key)) {
            this.warmestValue = preValue;
            this.eivarim.remove(key);
        }
        return preValue;
    }

    public V get(String key){
        return this.eivarim.get(key);
    }

    public V getWormest(){
        return this.warmestValue;
    }



}
