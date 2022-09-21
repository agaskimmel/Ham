package com.example;

import java.util.HashMap;

public class EvarHamStructure <V>{

    private HashMap<String, CellVal> eivarim = new HashMap<>();
    private String lastKey = null;

//
//    private V moveToTail(String key){
//        V preValue = removeKeyIfExcist(key);
//
//
//    }

    public void print(){
        System.out.println(eivarim.toString());
    }



    public V get(String key){
        if (key == lastKey){
            return this.eivarim.get(key).val;
        }

        V preValue = removeKeyIfExcist(key);
        if (preValue != null) {
            CellVal newCellVal = new CellVal(lastKey, preValue);
            addTail(key, newCellVal);
            this.lastKey = key;
            return this.eivarim.get(key).val;
        }
        return preValue;
    }

    public V put(String key, V value){
        V preValue;
        if(key.equals(this.lastKey)){
            preValue = this.eivarim.get(key).val;
            this.eivarim.get(key).val = value;
            return preValue;
        }

        preValue = removeKeyIfExcist(key);
        CellVal newCellVal = new CellVal(lastKey, value);
        addTail(key, newCellVal);
        this.lastKey = key;
        return preValue;
    }

    private void addTail(String key, CellVal newCellVal) {
        if (!this.eivarim.isEmpty()){
            this.eivarim.get(lastKey).nextKey = key;
        }
        this.eivarim.put(key,newCellVal);
    }

    private V removeKeyIfExcist(String key) {
        V currentVal = null;
        if(this.eivarim.containsKey(key)){
            currentVal = this.eivarim.get(key).val;
            String preKey = this.eivarim.get(key).preKey;
            String nextKey = this.eivarim.get(key).nextKey;
            tieNeiborsCells(preKey,nextKey);
            this.eivarim.remove(key);

        }
        return currentVal;
    }

    private void tieNeiborsCells(String preKey, String nextKey) {
        if (this.eivarim.containsKey(preKey)) {
            this.eivarim.get(preKey).nextKey = nextKey;
        }
        if(this.eivarim.containsKey(nextKey)) {
            this.eivarim.get(nextKey).preKey = preKey;
        }
    }

    public V remove(String key){
        if (key.equals(this.lastKey)){
            this.lastKey = this.eivarim.get(key).preKey;
        }

        return removeKeyIfExcist(key);
    }


    public V getWormest(){
        if (lastKey!=null) {
            return this.eivarim.get(lastKey).val;
        }
        return null;
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

        @Override
        public String toString() {
            return "CellVal{" +
                    "preKey='" + preKey + '\'' +
                    ", nextKey='" + nextKey + '\'' +
                    ", val=" + val +
                    '}';
        }
    }
}
