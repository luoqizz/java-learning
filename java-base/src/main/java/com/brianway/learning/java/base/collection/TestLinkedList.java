package com.brianway.learning.java.base.collection;

public class TestLinkedList {
    private Node first;
    private Node last;

    private  int size;

    public void add(Object obj){
        Node n = new Node();
        if(first == null){
            n.setPrevious(null);
            n.setObject(obj);
            n.setNext(null);

            first = n;
            last = n;
        }else {
            //直接往节点后增加新的节点
            n.setPrevious(last);
            n.setObject(obj);
            n.setNext(null);
            last.setNext(n);//给上一个节点next赋值
            last = n;
        }
        size ++;
    }


    public void add(Object obj,int index){
        Node temp = node(index);
        Node newNode = new Node();
        newNode.setObject(obj);

        if(temp != null){
            Node up = temp.getPrevious();
            newNode.setPrevious(up);
            newNode.setNext(temp);

            up.setNext(newNode);
            temp.setPrevious(newNode);
            size++;

        }

    }


    public Object get(int index){
        Node temp = node(index);
        return temp.getObject();
    }


    public void remove(int index){
        Node temp = node(index);
        if (temp != null){
            Node up = temp.getPrevious();
            Node down = temp.getNext();
            up.setNext(down);
            down.setPrevious(up);
            size--;
        }
    }

    public Node node(int index){
        rangeCheck(index);
        Node temp = null;
        if(first != null){
            temp = first;
            //如果要查的index 在后面则从后往前查，如果在前面则从前往后查 增加效率
            if(index < (size >>  1)){
                for (int i = 0 ; i < index ; i++){
                    temp = temp.getNext();
                }
            } else {
                for (int i = size -1 ; i > index ; i--){
                    temp = temp.getPrevious();
                }
            }

        }
        return temp;
    }

    public int size(){
        return size;
    }

    private void rangeCheck(int index){
        if(index >=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestLinkedList list = new TestLinkedList();
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("ccccc");
        list.add("ccccc");
        list.add("ccccc");
        list.add("BBBB",1);
        System.out.println(list.size());
        System.out.println(list.get(5));
        System.out.println(list.size());
    }
}
