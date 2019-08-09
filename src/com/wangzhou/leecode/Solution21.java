package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:19:37
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur;
        if(l1.val<=l2.val){
            cur=l1;
            cur.next=mergeTwoLists(l1.next,l2 );
        }else {
            cur=l2;
            cur.next=mergeTwoLists(l1,l2.next );
        }
        return cur;
    }
}
