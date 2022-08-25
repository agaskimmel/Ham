package com.example;

import java.util.HashMap;

public class EvarHamStructure {

    private HashMap<String, Integer> eivarim = new HashMap<>();
    private Integer warmestValue = null;

    public Integer put(String key, Integer value){
        Integer tempValue = null;
        if (this.eivarim.containsKey(key)){
            tempValue = eivarim.get(key);
        }
        this.warmestValue = value;
        this.eivarim.put(key, value);
        return tempValue;
    }

    public Integer remove(String key){
        Integer tempValue = null;
        if (this.eivarim.containsKey(key)){
            tempValue = eivarim.get(key);
            this.eivarim.remove(key);
        }
        return tempValue;
    }

    public Integer get(String key){
        return this.eivarim.get(key);
    }

    public Integer GetWormest(){
        return this.warmestValue;
    }



}
