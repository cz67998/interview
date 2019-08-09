package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:19:26
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current=head,pre=dummy;
        while (current!=null){
            if(current.val==val){
               current=current.next;
               pre.next=current;
            }else {
                pre=current;
                current=current.next;
            }
        }
        return dummy.next;
    }


}
