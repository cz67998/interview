package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:47
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = input.length;
        if (n == 0||n<k) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                list.add(queue.poll());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        ArrayList<Integer> list = solution29.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        for (Integer i : list
                ) {
            System.out.println(i);

        }
    }
}
