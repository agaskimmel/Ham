package com.example;

import org.junit.Assert;
import org.junit.Test;


public class EvarHamStructureTest<V> {



    @Test
    public void putFirstValGetNull() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        V valReturned = (V) evarHamStructure.put("a", "b");
        Assert.assertEquals(valReturned, null );
    }

    @Test
    public void putNewValGetpreVal(){
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("a", "1");
        V preVal = (V) evarHamStructure.put("a", "2");
        Assert.assertEquals(preVal, "1" );
    }

    @Test
    public void putValGetValAsWarmest(){
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("a", "1");
        evarHamStructure.put("e", "4");
        Assert.assertEquals(evarHamStructure.getWormest(), "4" );
    }

    @Test
    public void removeExcistKey() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("b", "2");
        evarHamStructure.remove("b");
        Assert.assertEquals(evarHamStructure.get("b"), null);
    }

    @Test
    public void removeExcistKeyGetPreVal() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("b", "2");
        V preVal = (V) evarHamStructure.remove("b");
        Assert.assertEquals(preVal, "2");
    }

    @Test
    public void removeNotExcistKeyGetPreValNull() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        V preVal = (V) evarHamStructure.remove("b");
        Assert.assertEquals(preVal, null);
    }

    @Test
    public void getExcistValByKey() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("a", "1");
        evarHamStructure.put("b", "2");
        evarHamStructure.put("c", "3");
        evarHamStructure.put("d", "4");
        evarHamStructure.put("e", "5");
        Assert.assertEquals(evarHamStructure.get("a"), "1");
        Assert.assertEquals(evarHamStructure.get("b"), "2");
        Assert.assertEquals(evarHamStructure.get("c"), "3");
        Assert.assertEquals(evarHamStructure.get("d"), "4");
        Assert.assertEquals(evarHamStructure.get("e"), "5");
    }

    @Test
    public void getValByNotExcistKey() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("a", "1");
        evarHamStructure.put("b", "2");
        evarHamStructure.put("c", "3");
        evarHamStructure.put("d", "4");
        evarHamStructure.put("e", "5");
        Assert.assertEquals(evarHamStructure.get("f"), null);
        Assert.assertEquals(evarHamStructure.get("g"), null);
        Assert.assertEquals(evarHamStructure.get("h"), null);
        Assert.assertEquals(evarHamStructure.get("k"), null);
        Assert.assertEquals(evarHamStructure.get("l"), null);
    }


    @Test
    public void getChangedValByNotExcistKey() {
        EvarHamStructure evarHamStructure = new EvarHamStructure();
        evarHamStructure.put("a", "1");
        evarHamStructure.put("f", "2");
        evarHamStructure.put("a", "2");
        evarHamStructure.put("c", "2");
        evarHamStructure.put("a", "3");
        evarHamStructure.put("e", "2");
        evarHamStructure.put("a", "4");
        evarHamStructure.put("f", "5");

        Assert.assertEquals(evarHamStructure.get("f"), "5");
        Assert.assertEquals(evarHamStructure.get("a"), "4");
    }










}