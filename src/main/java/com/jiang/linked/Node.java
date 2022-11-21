package com.jiang.linked;

/**
 * 文件名：Node
 * 创建者：JiangD
 * 创建时间：2022/11/7 13:13
 * 描述：存储元素的对象
 */
public class Node<T> {
    public Node pre;
    public T element;
    public Node next;


    public Node(Node pre, T element, Node next){
        this.pre = pre;
        this.element = element;
        this.next = next;
        //System.out.println("重载构造函数！！");
    }


}
