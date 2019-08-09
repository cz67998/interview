package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/12
 * Time:17:21
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null||head.next==null)return head;
        head.next=deleteDuplicates(head.next);
       if(head.val==head.next.val){
           head=head.next;
       }
       return head;
    }
}
