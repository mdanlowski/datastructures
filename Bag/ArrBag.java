//package com.mdski.datastr;

import java.util.Iterator;

public class ArrBag<T> implements Iterable<T>{

    private T[] contents;
    private int N;

    ArrBag(){
        this(10);
    }
    ArrBag(int initialSize){
        this.contents = (T[]) new Object[initialSize];
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void put(T item_){
        if ( N == contents.length ) resize(2*N);
        this.contents[N++] = item_;
    }

    private void resize(int newSize){
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++){
            newArr[i] = this.contents[i];
        }
        this.contents = newArr;
            System.out.println("Bag enlarged to " + newSize); // 4 TESTING ========================
    }

    public Iterator<T> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T>{
        int carret = 0;

        @Override
        public boolean hasNext() {
            return contents[carret] != null;
        }

        @Override
        public T next() {
            return contents[carret++];
        }
    }

}
