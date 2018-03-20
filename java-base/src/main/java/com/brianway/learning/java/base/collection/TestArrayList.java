package com.brianway.learning.java.base.collection;

public class TestArrayList {
    private Object [] elementData;

    private int size;

    public TestArrayList() {
        this(10);//初始化长度
    }

    public TestArrayList(int i) {
        if (i <0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[i];
    }

    public void add(Object o){
        //实现数组扩容
        if(size==elementData.length){
            Object[] newArrayList = new Object[size*2+1];
            System.arraycopy(elementData,0,newArrayList,0,elementData.length);
            elementData = newArrayList;
        }
        elementData[size++] = o; //先赋值后自增
    }

    public void add(int index,Object o){
        rangeCheck(index);
        //实现数组扩容
        if(size==elementData.length){
            Object[] newArrayList = new Object[size*2+1];
            System.arraycopy(elementData,0,newArrayList,0,elementData.length);
            elementData = newArrayList;
        }
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = o;
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void remove(int index){
        //判断数组是否越界
        rangeCheck(index);

        int numMoved = size - index -1;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
            elementData[--size] = null;
        }

    }

    public void remove(Object obj){
        for (int i = 0;i<size;i++){
            if (get(i).equals(obj)){
                remove(i);
            }
        }
    }

    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
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
        TestArrayList list = new TestArrayList();
        list.add("123123");
        list.add("123123");
        list.add("123123");
        list.add("123123");
        list.add("123123");
        list.add("123123");
        list.remove(1);
        System.out.println(list.size());

    }


}
