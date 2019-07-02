package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:9:36
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = head;
        q = head;
        int a = k;
        int count = 0;
        //当q指向第k+1时，p同时指向1
        while (q != null) {
            q = q.next;
            count++;
            if (a < 1) {
                p = p.next;
            }
            a--;
        }
        if (count < k) return null;
        return p;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int count=0;
        int a=k;
        while (p!=null&&a>0){
            count++;
            p=p.next;
            a--;
        }
        while (p!=null){
            count++;
            p=p.next;
            q=q.next;
        }
        if (count < k) return null;
        return q;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.FindKthToTail1(listNode, 2));
    }

}

