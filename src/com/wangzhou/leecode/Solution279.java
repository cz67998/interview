package com.wangzhou.leecode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:10:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution279 {
    class Node {
        int val;
        int step;

        Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }


    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int num = node.val;
            int step = node.step;
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[a]) {
                    queue.add(new Node(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Solution279 solution279 = new Solution279();
//        System.out.println(solution279.numSquares(5));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.peek());
    }

}



