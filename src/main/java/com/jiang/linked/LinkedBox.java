package com.jiang.linked;

import com.jiang.Interface.ListInterface;
import com.jiang.exception.BoxIndexOutOfBoundsException;

/**
 * 文件名：LinkedBoxSystem.out.println("aaa");
 * 创建者：JiangD
 * 创建时间：2022/10/13 9:52
 * 描述：TODO
 */
public class LinkedBox<T> implements ListInterface<T> {

    //记录头Node节点
    Node first;
    //记录尾Node节点
    Node last;
    //记录有效元素的个数
    private int size = 0;

    //添加元素
    @Override
    public boolean add(T e) {
        //将添加元素的方法封装
        this.linkLast(e);
        return true;
    }
    //向指定位置添加元素
    public void add(int index,T e){

    }
    //获取指定位置的元素
    @Override
    public T get(int index) {
        //首先判断索引位置是否合法
        this.rangeCheck(index);
        //找寻index对应位置的那个Node对象
        Node targetNode = this.node(index);
        //将targetNode中的元素返回
        return (T) targetNode.element;
    }
    //获取元素的具体实现方法,找寻索引对应的元素
    private Node node(int index) {
        Node targetNode;//用来存储找寻到的目标节点
        //判断index对应的位置，是在前半部分还是在后半部分
        if(index<size>>1){//从前向后搜索
            targetNode = first;
            for (int i = 0;i<index;i++){
                targetNode = targetNode.next;
            }
        }else {//从后向前搜索
            targetNode = last;
            for (int i = size-1;i>index;i--){
                targetNode = targetNode.pre;
            }
        }
        return targetNode;
    }

    //删除指定位置元素
    @Override
    public T remove(int index) {
        //判断索引位置是否合法
        this.rangeCheck(index);
        //获取要删除索引位置的节点
        Node targetNode = this.node(index);
        //调用删除方法
        T oldNode = this.removeNode(targetNode);
        return oldNode;
    }
    //删除具体实现方法
    private T removeNode(Node targetNode) {
        //获取要删除的元素
        T oldValue = (T)targetNode.element;
        //获取要删除元素的上一个节点
        Node pre = targetNode.pre;
        //获取要删除元素的下一个节点
        Node next = targetNode.next;
        //删除当前节点
        //打断前半部分连接
        if(pre == null){//删除的情况为第一个元素
            first = next;
        }else {//删除链表中间的元素
            pre.next = next;
            //在中间需要打断前边的节点
            targetNode.pre = null;
        }
        //打断后半部分连接
        if (next == null){//删除的情况为最后一个元素
            last = pre;
        }else {//删除链表中间的元素
            next.pre = pre;
            //在中间需要打断后边的节点
            targetNode.next = null;
        }
        //删除成功，有效元素-1
        size--;
        //将要删除的元素进行返回
        return oldValue;
    }

    //添加实现
    private void linkLast(T e){
        //获取链表的尾节点对象
        Node l = last;
        //创建新的节点对象作为容器存储元素及连接上一个节点的对象
        Node<T> newNode = new Node<T>(l,e,null);
        //存储成功将新节点对象设置为尾节点
        last = newNode;
        if(l == null){//如果为空代表此链表还没有已经存在的节点
            //那么首节点就是新节点
            first  = newNode;
        }else{//链表的下一个对象为新节点，上一个节点的next指向新节点
            l.next = newNode;
        }
        size++;
    }
    //检查索引位置的元素是否合法
    private void rangeCheck(int index){
        if (index<0||index>=size){
            throw new BoxIndexOutOfBoundsException("下标为：" + index + "数组长度为：" + size);
        }
    }

    public int size() {
        return size;
    }
}
