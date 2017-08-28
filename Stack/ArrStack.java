package com.mdski.datastr;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrStack<T> implements Iterable<T>{
    private T[] contents;
    private int N; // Number of items in the stack, so equal to length

    ArrStack(){
        this.contents = (T[]) new Object[2]; // https://stackoverflow.com/questions/11404086/how-could-i-initialize-a-generic-array
        this.N = 0;
    }

    // SOLUTIONS

    //* You could use something like this T[] items=(T[])new Object[size]; but it will create array of objects so you will be able to
    //* insert there any object via raw type reference. It would be nice it you had some instance of T type or class literal,
    //* then you could use it to create normal array of T type for example like this.
    //
    //      public static <T> T[] createArray(Class<T> type, int size){
    //      return (T[])Array.newInstance(type, size);
    //      }
    //

    //class GenericArrayTest<T>{
    //T[] array1; // this array will be created by (T[])new Object[size];
    //Object[] array2; // this will be created by new Object[size]
    //T[] array3; // and this as (T[])Array.newInstance(type, size);
    //
    //GenericArrayTest(Class<T> type, int size){
    //array1=(T[])new Object[size];
    //array2=new Object[size];
    //array3=(T[])Array.newInstance(type, size);
    //}
    //
    //void put1(T data, int index){ array1[index]=data; }
    //void put2(T data, int index){ array2[index]=data; }
    //void put3(T data, int index){ array3[index]=data; }
    //
    //T get1(int index){ return array1[index]; }
    //T get2(int index){ return (T)array2[index]; }
    //T get3(int index){ return array3[index]; }
    //
    //void showArraysRow(int index){
    //System.out.println(get1(index)+" "+get2(index)+" "+get3(index));
    //}
    //
    ////TEST
    //public static void main(String[] args) {
    ////we will put
    //GenericArrayTest<Integer> k=new GenericArrayTest<Integer>(Integer.class,10);
    //k.put1(666, 0);
    //k.put2(666, 0);
    //k.put3(666, 0);
    //
    //k.showArraysRow(0);
    //
    ////I CREATE RAW TYPE REFERENCE - no generic control anymore
    //GenericArrayTest k2=k;
    //k2.put1("data1", 0);
    //k2.put2("data2", 0);
    ////      k2.put3("data3", 0);//<- this would throw ArrayStoreException - wrong data type
    //
    //k2.showArraysRow(0);
    //}
    //}
    //

    public void push(T item){
        // CHECK SIZE
        if( this.N == this.contents.length ) resize(2*N);
        this.contents[N++] = item; // PUSH ITEM TO INDEX [N] AND THEN INCREMENT N
//        N++;
    }

    public T pop(){
        // CHECK IF ANYTHING TO POP
        if ( N >= 1 ) {
            T item = this.contents[N - 1];
            this.contents[N--] = null; // POP ITEM FROM INDEX [N] AND DECREMENT N
            if ( N == this.contents.length/4 ) resize(2*N);
            return item;
        }
        else throw new NoSuchElementException("Stack is empty");
    }

    public int size(){
        return N;
    }

    public int capacity(){
        return this.contents.length;
    }

    public boolean isEmpty(){
        return ( this.size() == 0 );
    }

    private void resize(int newCap){
        T[] resContents = (T[]) new Object[newCap];
            System.out.println("stack capacity resized to: " + newCap); // ============= TEST LINE
        for (int i = 0; i < N; i++){
            resContents[i] = contents[i];
        }
        contents = resContents;

    } // ========= resize method =================

    public Iterator<T> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        // IN ORDER FOR ITEMS TO APPEAR IN STACK ORDER
        // ITERATION WILL HAVE TO GO BACKWARDS
//        private T[] things = contents;
        private int top = N-1;    // -1 bc will be used as index

        @Override
        public boolean hasNext() {
            return top != -1;       // IT APPEARS THAT next() IS INVOKED BEFORE hasNext()
        }

        @Override
        public T next() {
            if (hasNext()) {
                T item = contents[top--];
                return item;
            }
            else throw new NoSuchElementException("Iteration ended");
        }
    }

}
