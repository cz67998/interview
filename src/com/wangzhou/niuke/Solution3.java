package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/24
 * Time:17:27
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode current = listNode;
        while (current != null) {
            list.add(current.val);
            current = current.next;

        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list1.add(list.get(i));
        }
        return list1;
    }

    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) {
            return list;

        }
        printListFromTailToHead1(listNode.next);
        list.add(listNode.val);
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("[ ");
        ListNode root = this;
        while (root != null) {
            res.append(root.val);
            root = root.next;
            res.append("->");
        }
        res.append("NULL ]");
        return res.toString();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(listNode);
    }
}