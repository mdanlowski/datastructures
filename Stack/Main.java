//package com.mdski.datastr;

public class Main {

    public static void main(String[] args) {

       /* LLStack<String> stack = new LLStack<>();

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push("ayy");
        stack.push("lmao");
        stack.push("ayyyyyy");
        stack.push("ayliens");

        for(String item : stack){
            System.out.print(item + " ");
        }
/*
//*        System.out.println(stack.size());
//*        System.out.println(stack.pop());
//*        System.out.println(stack.size());
//*        System.out.println(stack.isEmpty());
*/

        ArrStack<String> strstack = new ArrStack<>();

        System.out.println("sz: " + strstack.size());
        System.out.println("cap: " + strstack.capacity());
////        System.out.println(strstack.isEmpty());
//        strstack.push("ayy");
//
//        System.out.println(strstack.size());
//        System.out.println(strstack.capacity());
//        strstack.push("lmao");
//
//        System.out.println(strstack.size());
//        System.out.println(strstack.capacity());
//        strstack.push("aliens will come");

        for( int i = 0; i < 100; i++){
            Integer c = i;
//            System.out.println(c.toString());
            strstack.push(c.toString());
        }
        System.out.println("sz: " + strstack.size());
        System.out.println("cap: " + strstack.capacity());
        System.out.println(strstack.pop());
        System.out.println(strstack.pop());
        System.out.println(strstack.pop());
        System.out.println("sz: " + strstack.size());
        System.out.println("cap: " + strstack.capacity());

        for (String item : strstack){
            System.out.print(item + " ");
        }



    }
}