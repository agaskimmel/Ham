package com.example;

import java.io.Console;

public class Ham {


    public static void main(String[] args) {

        EvarHamStructure ham = new EvarHamStructure();

        System.out.println(ham.get("a"));
        System.out.println(ham.getWormest());
        System.out.println(ham.put("a", "aaa"));
        System.out.println("aaa: " + ham.getWormest());
        System.out.println(ham.put("a",101));
        System.out.println(ham.put("a",101));
        System.out.println(ham.get("a"));
        System.out.println(ham.remove("a"));
        System.out.println(ham.getWormest());



    }
}
