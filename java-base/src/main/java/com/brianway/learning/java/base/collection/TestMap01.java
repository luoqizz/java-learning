package com.brianway.learning.java.base.collection;

/**
 * Map：存放键值对，根据键对象找到对应的对象，键不能重复
 */
public class TestMap01 {
    TestEntry [] arr = new TestEntry[999];
    int size;

    public void put(Object key,Object value){
        TestEntry t = new TestEntry(key,value);
        //解决键值对存在问题
        for (int i = 0 ; i<size ; i++){
            if(arr[i].key.equals(key)){
                arr[i].value = value;
                return;
            }
        }
        arr[size++] = t;
    }

    public Object get(Object key){
        for (int i = 0 ; i < size ; i ++){
            if(arr[i].key.equals(key)){
                return  arr[i].value;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        TestMap01 map = new TestMap01();
        map.put("hehe","xixi");
        System.out.println(map.get("hehe"));
    }

    public boolean containsKey(Object key){
        for (int i = 0 ; i<size ; i++){
            if(arr[i].key.equals(key)){
                return  true;
            }
        }
        return  true;
    }

    public boolean containsValue(Object value){
        for (int i = 0 ; i<size ; i++){
            if(arr[i].value.equals(value)){
                return  true;
            }
        }
        return  true;
    }


}

class TestEntry{
    Object key;
    Object value;

    public TestEntry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
}