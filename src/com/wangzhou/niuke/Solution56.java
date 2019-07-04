package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/4
 * Time:14:03
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        //虚拟头节点
        ListNode currentNode = pHead, dummyNode = new ListNode(-1);
        dummyNode.next = pHead;
        //纪录前一个节点
        ListNode preNode = dummyNode;
        boolean flag = false;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (nextNode == null) break;
            if (nextNode.val == currentNode.val) {
                while (nextNode != null && nextNode.val == currentNode.val) {
                    nextNode = nextNode.next;
                }
                preNode.next = nextNode;
                currentNode = nextNode;
            } else {
                if (!flag) {
                    dummyNode.next = currentNode;
                    flag = true;
                }
                preNode = currentNode;
                currentNode = nextNode;

            }

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(solution56.deleteDuplication(listNode));

    }
}
