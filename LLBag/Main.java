//package com.mdski.datastr;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LLBag<Integer> b = new LLBag<>();

        System.out.println(b.isEmpty());
        System.out.println(b.size());

        b.add(5);
        b.add(7);

        // TEST THE EXCEPTION
//        Iterator<Integer> iter = b.iterator();
//        while (!iter.hasNext()){
//            System.out.println(iter.next());
//        }

        // TEST THE ITERATION
        for (Integer i : b){
            System.out.println(i);
        }

        System.out.println(b.isEmpty());
        System.out.println(b.size());

    }
}
