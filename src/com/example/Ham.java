package com.example;

public class Ham {




    public static void main(String[] args) {

        EvarHamStructure ham = new EvarHamStructure();

        System.out.println(ham.get("a"));
        System.out.println(ham.getWormest());
        System.out.println(ham.put("a", "aaa"));
        System.out.println("aaa: " + ham.getWormest());

        System.out.println(ham.put("a",101));
        System.out.println("a: " + ham.getWormest());
        System.out.println(ham.put("a",102));
        System.out.println("a: " + ham.getWormest());
        System.out.println(ham.get("a"));
        System.out.println(ham.remove("a"));
        System.out.println(ham.get("a"));
        System.out.println(ham.getWormest());


        System.out.println(ham.put("a", "1"));
        System.out.println(ham.getWormest());
        System.out.println(ham.put("b", "2"));
        System.out.println(ham.getWormest());

        print(ham.getWormest());
        ham.print();
        print(ham.get("a"));
        ham.print();






    }

    private static void print(Object wormest) {
        System.out.println(wormest);
    }
}
