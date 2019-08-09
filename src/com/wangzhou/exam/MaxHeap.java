package com.wangzhou.exam;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:9:53
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    private MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    private MaxHeap() {
        this(10);
    }

    //heapify  生成heap
    private MaxHeap(E[] arr) {
        data = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    //父亲节点
    private int parent(int i) {
        return (i - 1) / 2;
    }

    //左孩子
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    //右孩子
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    //下浮
    private void siftDown(int k) {
       while (leftChild(k)<data.size()){
           int j=leftChild(k);
           if(j+1<data.size()&&data.get(j+1).compareTo(data.get(j))>0)j++;
           if(data.get(k).compareTo(data.get(j))>0)break;
           swap(k,j );
           k=j;
       }
    }

    //交换元素
    private void swap(int k, int j) {
        E temp = data.get(k);
        data.set(k, data.get(j));
        data.set(j, temp);
    }

    //上浮
    private void siftUp(int k) {
      while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
          swap(k,parent(k) );
          k=parent(k);
      }
    }

    //添加元素
    private void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    //取出最大元素，并删除该元素
    private E pop() {
      E ret=data.get(0);
      swap(0,data.size()-1 );
      data.remove(data.size()-1);
      siftDown(0);
      return ret;
    }
    public static void main(String[] args){
        MaxHeap<Integer> maxHeap=new MaxHeap(new  Integer[]{1,2,3,4,5});
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.data);
    }
}
