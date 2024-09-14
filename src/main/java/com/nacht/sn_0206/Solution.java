package com.nacht.sn_0206;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/15 01:04
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            /*当前节点的下一个节点临时存起来*/
            ListNode tmp = current.next;
            /*当前节点指向前一个节点*/
            current.next = prev;
            /*前一个节点设置为当前节点*/
            prev = current;
            /*当前节点设置为下一个节点*/
            current = tmp;
        }
        return prev;
    }
}
