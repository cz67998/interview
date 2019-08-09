package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:17:48
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.remove().getKey());
        }
        return list;
    }
    public static void main(String[] args){
        Solution347 solution347=new Solution347();
        System.out.println(solution347.topKFrequent(new int[]{1}, 1));
    }
}

