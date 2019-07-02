package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:00
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode coneNode = new RandomListNode(currentNode.label);
            coneNode.next = currentNode.next;
            currentNode.next = coneNode;
            currentNode = currentNode.next.next;
        }
        currentNode = pHead;

        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }

        currentNode = pHead;
        RandomListNode dummyConeHead = new RandomListNode(-1);
        RandomListNode coneHead=dummyConeHead;
        while (currentNode != null) {
            coneHead.next = currentNode.next;
            currentNode.next = currentNode.next.next;
            coneHead=coneHead.next;
            currentNode = currentNode.next;
        }
        return dummyConeHead.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}