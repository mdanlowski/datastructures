//package com.mdski.datastr;
import java.util.Iterator;

public class LLStack<T> implements Iterable<T>{
    private Node head = null;

    class Node {
        T item;
        Node next;
    }

    public void push(T item_){
        Node oldhead = head;
        head = new Node();
        head.item = item_;
        head.next = oldhead;
    }

    public T pop(){
        T item_ = head.item;
        head.item = null;
        head = head.next;
        return item_;
    }

    public int size(){
        Node current = head;
        int size = 0;
        while (current != null){
            size ++;
            current = current.next;
        }
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // ======= client-side iteration interface
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T> {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null; // NOT current.next != null because the list has to have THE FIRST element as well, then next() is called and eventually current.next != null is checked
        }

        @Override
        public T next() {
            T item_ = current.item;
            current = current.next;
            return item_;
        }
    }
}
