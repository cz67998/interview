package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:13:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode current = head, pre = null, parepare = null, fast = head.next;
        while (fast != null&& fast.next != null) {
            pre=current;
            current=current.next;
            fast=fast.next.next;
            pre.next=parepare;
            parepare=pre;
        }
        ListNode p2=current.next;
        current.next=pre;
        ListNode p1=fast==null?current.next:current;
        while (p1!=null){
            if(p1.val!=p2.val)return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        System.out.println(solution234.isPalindrome(LinkNodeUtil.createLinkList(new int[]{1, 2, 1}, 3)));
    }
}
