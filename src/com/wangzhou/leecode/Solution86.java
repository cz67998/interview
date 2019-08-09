package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:13:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode node = new ListNode(-1);
        ListNode dummy = node;
        ListNode current = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummy1=pre;
        while (current != null) {
            if (current.val >= x) {
                ListNode node1=new ListNode(current.val);
                node.next = node1;
                node = node.next;
                current = current.next;
                pre.next = current;
            } else {
                pre = current;
                current = current.next;
            }
        }
        pre.next = dummy.next;
        return dummy1.next;
    }
    public static void main(String[] args){
        Solution86 solution86=new Solution86();
        System.out.println(solution86.partition(LinkNodeUtil.createLinkList(new int[]{1,4,3,2,5,2}, 6), 3));
        System.out.println(solution86.partition(LinkNodeUtil.createLinkList(new int[]{2,1}, 2), 2));
        System.out.println(solution86.partition(LinkNodeUtil.createLinkList(new int[]{1}, 1), 0));
    }
}
