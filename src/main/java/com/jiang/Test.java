package com.jiang;

import com.jiang.array.ArrayBox;
import com.jiang.linked.LinkedBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件名：Test
 * 创建者：JiangD
 * 创建时间：2022/10/13 19:18
 * 描述：TODO
 */
public class Test {
    public static void main(String[] args) {

//
//        //原ArrayList集合
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("1");
//        System.out.println(arrayList);
//
//        //手撕ArrayList集合
//        ArrayBox<Integer> arrayBox = new ArrayBox<>();
//        for (int i = 1;i < 7;i++){
//            arrayBox.add(i);
//        }
//        byte p = 3; // 编译正确:int到byte编译过程中发生隐式类型转换
//        int  a = 3;
//        byte b = a; // 编译出错：cannot convert from int to byte
//        byte c = (byte) a; // 编译正确
//        float d = (float) 4.0;
//        int k = (int)1.6;
//        System.out.println(k);
//        Object remove = arrayBox.remove(2);
//        for (int i = 0;i < 5;i++){
//            System.out.println(arrayBox.get(i));
//        }
//        System.out.println(arrayBox.size());
//        System.out.println(arrayBox.length());
//        System.out.println(remove);

//        //原LinkedList集合
//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add("1");
//        System.out.println(linkedList);
//        //手撕LinkedList集合
//        LinkedBox<String> linkedBox = new LinkedBox<>();
//        linkedBox.add("1");
//        System.out.println(linkedBox);

        //手撕LinkedList集合
        LinkedBox<Integer> stringLinkedBox = new LinkedBox<>();
        for(int i = 0; i<5;i++){
            stringLinkedBox.add(i);
            System.out.println(stringLinkedBox.get(i));
        }
        System.out.println(stringLinkedBox.size());
    }
}
