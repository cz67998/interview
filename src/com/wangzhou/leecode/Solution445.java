package com.wangzhou.leecode;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:15:32
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution445 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            carry=carry/10;
            if (!stack1.isEmpty() ){
                carry+=stack1.pop();
            }
            if (!stack2.isEmpty() ){
                carry+=stack2.pop();
            }
            ListNode node=new ListNode(carry%10);
            node.next=dummy.next;
            dummy.next=node;
        }
        if(carry/10==1){
            ListNode node=new ListNode(1);
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy, l3 = l1, l4 = l2;
        int m = 0;
        while (l3 != null) {
            m++;
            l3 = l3.next;
        }
        int n = 0;
        while (l4 != null) {
            n++;
            l4 = l4.next;
        }
        int carry = 0;
        while (l1 != null && l2 != null) {
            if (m > n) {
                ListNode node = new ListNode(l1.val);
                ans.next = node;
                ans = ans.next;
                l1 = l1.next;
                m--;
            } else if (m < n) {
                ListNode node = new ListNode(l2.val);
                ans.next = node;
                ans = ans.next;
                l2 = l2.next;
                n--;
            } else {
                carry = carry / 10;
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }
                ListNode node = new ListNode(carry % 10);
                ans.next = node;
                ans = ans.next;
            }
        }
        if (carry / 10 == 1) {
            ans.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution445 solution445 = new Solution445();
        System.out.println(solution445.addTwoNumbers1(LinkNodeUtil.createLinkList(new int[]{5}, 1),
                LinkNodeUtil.createLinkList(new int[]{5}, 1)));
    }

}
