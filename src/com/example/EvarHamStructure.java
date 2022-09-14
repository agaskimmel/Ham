package com.example;

import java.util.HashMap;

public class EvarHamStructure <T>{

    private HashMap<String, T> eivarim = new HashMap<>();
    private T warmestValue = null;


    public T put(String key, T value){
        T preValue = this.get(key);
        this.eivarim.put(key, value);
        this.warmestValue = value;
        return preValue;
    }

    public T remove(String key){
        T preValue = this.get(key);
        this.eivarim.remove(key);
        this.warmestValue = preValue;
        return preValue;
    }

    public T get(String key){
        return this.eivarim.get(key);
    }

    public T getWormest(){
        return this.warmestValue;
    }



}
