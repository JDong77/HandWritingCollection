package com.jiang.array;

import com.jiang.Interface.ListInterface;
import com.jiang.exception.BoxIndexOutOfBoundsException;

/**
 * 文件名：ArrayBox
 * 创建者：JiangD
 * 创建时间：2022/10/13 9:51
 * 描述：TODO
 */
public class ArrayBox<T> implements ListInterface<T>{

    //存储数组容量
    private final static int INDEX_CAPACITY = 10;
    //存储元素得数组
    private Object[] element;
    //存储元素有效个数
    private int size = 0;
    //懒汉式加载（创建对象时加载数组对象）
    public ArrayBox(){
        //创建数组对象用来存储元素
        element = new Object[INDEX_CAPACITY];
    }
    public ArrayBox(int Capacity){
        element = new Object[Capacity];;
    }
    //获取元素的个数
    public int size(){
       return size;
    }
    //获取数组的长度
    public int length(){
        return element.length;
    }

    //添加元素
    @Override
    public boolean add(T e) {
        //确保数组容量足够
        this.ensureCapacityInternal(size+1);
        //将获取得元素写入数组中
        element[size++] = e;
        //存入成功
        return true;
    }
    //指定位置添加元素
    public boolean add(int index, T e){
        //1.确保数组有容量

        //2.从size---index倒叙，向后移动覆盖，前面的index位置空出来

        //3.元素存入index位置
        return true;
    }

    //确保容量够用的方法
    private void ensureCapacityInternal(int minCapacity) {
        //容量不够时
        if (minCapacity > element.length) {
            //调用扩容的方法
            this.grow(minCapacity);
        }
    }
    //①数组容量扩容1.5倍
    private void grow(int minCapacity) {
            //获取旧数组容量
            int oldCapacity = element.length;
            //旧数组容量扩容1.5倍
            int newCapacity = oldCapacity + (oldCapacity>>1);
//            //如果扩容后容量小于原数组容量，新数组容量就等于旧数组容量
//            if(newCapacity<oldCapacity){
//                newCapacity = oldCapacity;
//            }
        element = this.copyOf(element, newCapacity);
    }
    //②将旧数组中的元素移动到新数组
    private Object[] copyOf(Object[] oldArray , int newCapacity){
        //定义新数组用来接收旧数组中的元素，携带新的数组容量
        Object[] newArray = new Object[newCapacity];
        //旧数组元素复制到新数组中
        for(int i = 0; i < newCapacity;i++){
            newArray[i] = oldArray[0];
        }
        return  newArray;
    }

    //获取指定位置的元素
    @Override
    public T get(int index) {
        this.rangeCheck(index);
        return (T)element[index];
    }
    //删除指定位置的元素    1,2,3,4   1,3,4
    @Override
    public T remove(int index) {
        //判断索引位置是否合法
        this.rangeCheck(index);
        //将要删除的元素进行保存并返回
        T oldElement = (T)element[index];
        //从删除的元素位置开始前移覆盖
        for (int i = index ; i < size -1 ; i++){
            element[i] = element[i+1];
        }
        //将最后一个位置的元素删除
        element[--size] = 0;
        return oldElement;
    }

    //检查索引位置的元素是否合法
    private void rangeCheck(int index){
        if (index<0||index>=size){
            throw new BoxIndexOutOfBoundsException("下标为：" + index + "数组长度为：" + size);
        }
    }

}
