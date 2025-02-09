package com.nacht.util;

/**
 * @author Nacht
 * Created on 2023/11/10 13:12
 */
public class Node<V> {

    public Node(V value){
        this.value = value;
    }

    private V value;
    private Node<V> next;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public Node<V> setNext(Node<V> next) {
        this.next = next;
        return this.next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
