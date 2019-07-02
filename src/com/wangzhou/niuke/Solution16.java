package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:16:21
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dymmyHead = new ListNode(0);
        ListNode currentHead = dymmyHead;
        while (list1 != null&&list2 != null) {
            if (list1.val <= list2.val) {
                ListNode node = new ListNode(list1.val);
                currentHead.next = node;
                list1 = list1.next;
            } else {
                ListNode node = new ListNode(list2.val);
                currentHead.next = node;
                list2 = list2.next;
            }
            currentHead = currentHead.next;
        }
        if(list1 == null&&list2 != null){
            currentHead.next=list2;
        }
        if(list1 != null&&list2 == null){
            currentHead.next=list1;
        }
        return dymmyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);

        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(5);

        Solution16 solution16 = new Solution16();
        System.out.println(solution16.Merge(listNode, listNode1));
    }
}
