package com.example;

import java.util.HashMap;

public class EvarHamStructure <V>{

    private HashMap<String, CellVal> eivarim = new HashMap<>();
    private String lastKey = null;


    public V put(String key, V value){
        V preValue = removeKeyIfExcist(key);
        CellVal newCellVal = new CellVal(lastKey, value);
        addTail(key,newCellVal);
        this.lastKey = key;
        return preValue;
    }

    private void addTail(String key, CellVal newCellVal) {
        this.eivarim.get(key).nextKey = key;
        this.eivarim.put(key,newCellVal);
    }

    private V removeKeyIfExcist(String key) {
        V currentVal = null;
        if(this.eivarim.containsKey(key)){
            currentVal = this.eivarim.get(key).val;
            String preKey = this.eivarim.get(key).preKey;
            String nextKey = this.eivarim.get(key).nextKey;
            updateNeiborsCells(preKey,nextKey);
        }
        return currentVal;
    }

    private void updateNeiborsCells(String preKey, String nextKey) {
        this.eivarim.get(preKey).nextKey = nextKey;
        this.eivarim.get(nextKey).preKey = preKey;
    }

    public V remove(String key){
        return removeKeyIfExcist(key);
    }

    public V get(String key){
        V preValue = removeKeyIfExcist(key);
        CellVal newCellVal = new CellVal(lastKey, preValue);
        addTail(key,newCellVal);
        this.lastKey = key;
        return this.eivarim.get(key).val;
    }

    public V getWormest(){
        return this.eivarim.get(lastKey).val;
    }

    private class CellVal {
        private String preKey;
        private String nextKey;
        private V val;

        public CellVal(String preKey, V val) {
            this.preKey = preKey;
            this.val = val;
            this.nextKey = null;
        }

        public void setPreKey(String preKey) {
            this.preKey = preKey;
        }

        public void setNextKey(String nextKey) {
            this.nextKey = nextKey;
        }



        public String getPreKey() {
            return preKey;
        }

        public String getNextKey() {
            return nextKey;
        }

        public V getVal() {
            return val;
        }

    }
}
