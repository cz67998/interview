package com.wangzhou.leecode;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:20:18
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null)return null;
       ListNode dummy=new ListNode(-1);
        dummy.next=head;
       ListNode pre=dummy,end=dummy;
       while (end.next!=null){
           for (int i = 0; end!=null&&i < k; i++) {
               end=end.next;
           }
           if(end==null)break;
           ListNode next=end.next;
           end.next=null;
           ListNode start=pre.next;
           pre.next=reverse(start);
           start.next=next;
           end=start;
           pre=end;
       }
       return dummy.next;
    }

    private ListNode reverse(ListNode next) {
        if (next == null || next.next == null) return next;
        ListNode listNode = reverse(next.next);
        next.next.next = next;
        next.next = null;
        return listNode;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        System.out.println(solution25.reverseKGroup(LinkNodeUtil.createLinkList(new int[]{1, 2, 3, 4, 5}, 2), 3));
    }
}
