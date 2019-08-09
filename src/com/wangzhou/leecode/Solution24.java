package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:20:12
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode temp=head.next;
        head.next=swapPairs(temp.next);
        temp.next=head;
        return temp;
    }
}
