package com.wangzhou.leecode;

import java.math.BigDecimal;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:21:38
 **/
public class Solution2 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            carry = carry / 10;
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode listNode = new ListNode(carry % 10);
            ans.next = listNode;
            ans = ans.next;
        }
        if(carry/10==1){
            ans.next=new ListNode(1);
        }
        return dummy.next;
    }

    ListNode head;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                res.append(node.val + "->");
                node = node.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    private ListNode createLinkedList(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        head = new ListNode(arr[0]);
        ListNode currentHead = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(arr[i]);
            currentHead.next = node;
            currentHead = currentHead.next;
        }
        return head;
    }

    public int reverse(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + reverse(node.next) * 10;
    }

    public int[] reverse(int a) {
        String s = Integer.toString(a);
        int n = s.length();
        int[] ints = new int[n];
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            ints[j] = Integer.parseInt(String.valueOf(s.charAt(i)));
            j++;
        }

        return ints;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummyNode = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            carry /= 10;
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(carry % 10);
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        if (carry / 10 == 1) {
            dummyNode.next = new ListNode(1);
        }
        return head.next;
//        int a = reverse(l1);
//        int b = reverse(l2);
//        Integer c = a + b;
//        System.out.println(c);
//        String s = Integer.toString(c);
//        int[] nums = reverse(c);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//
//        return createLinkedList(nums);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode L1 = solution2.createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode L2 = solution2.createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
//      System.out.println(solution2.reverse(L1));
        System.out.println(solution2.addTwoNumbers(L1, L2));

        System.out.println();
    }

}
