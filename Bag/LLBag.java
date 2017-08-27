//package com.mdski.datastr;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class implementing a simple Bag Data Structure using a Linked List
 * @param <T> - data type
 * @author Marcin Danlowski (https://github.com/mdanlowski)
 */
public class LLBag<T> implements Iterable<T> {
    private Node first = null;

    private class Node{     // Inner class for linked list element
        T item;
        Node next;
    }

    LLBag() {               // Default constructor
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void add(T _item){   // Just as push(), no pop() though, as what we have here is a bag DS
        Node before = first;    // copy most recently created node
        first = new Node();     // reserve new node as the NEW most recently created node
        first.item = _item;     // set the content of most recently created node equal to the pushed item
        first.next = before;    // set the reference of the fresh node pointing to the node added directly before
    }

    public int size(){     // Returns number of items in the bag
        int s = 0;
        Node current = this.first;
        while (current != null) {
            s++;
            current = current.next;
        }
        return s;
    }

    public Iterator<T> iterator() { return new BagIterator(); }

    private class BagIterator implements Iterator<T>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            if ( !hasNext() || isEmpty() ) throw new NoSuchElementException("List ended or empty!");
            T item = current.item;
            current = current.next;
            return item;
        }
    }

}
