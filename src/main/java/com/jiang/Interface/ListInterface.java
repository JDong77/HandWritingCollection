package com.jiang.Interface;

/**
 * 文件名：ListInterface
 * 创建者：JiangD
 * 创建时间：2022/10/13 19:34
 * 描述：TODO
 */
public interface ListInterface<T> {
    //添加元素
    boolean add(T e);

    //获取指定位置的元素
    Object get(int index);

    //删除指定位置的元素
    Object remove(int index);

}
