package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/12
 * Time:17:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class LinkNodeUtil {
    public static ListNode createLinkList(int arr[], int n) {
        if (n == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static String printLinkList(ListNode head) {
        StringBuilder res = new StringBuilder("[ ");
        while (head != null) {
            res.append(head.val);
            head = head.next;
            res.append("->");
        }
        res.append("NULL ]");
        return res.toString();
    }
    public static void main(String[] args){
        System.out.println(LinkNodeUtil.printLinkList(LinkNodeUtil.createLinkList(new int[]{1,2,3},3 )));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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
}