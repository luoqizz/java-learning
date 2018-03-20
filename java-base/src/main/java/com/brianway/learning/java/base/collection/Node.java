package com.brianway.learning.java.base.collection;

/**
 * 链表list节点类
 */
public class Node {
    private Node previous;//上一个节点
    private Object object;//当前对象
    private Node next;//下一个节点

    public Node() {
    }

    public Node(Node previous, Object object, Node next) {
        this.previous = previous;
        this.object = object;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
