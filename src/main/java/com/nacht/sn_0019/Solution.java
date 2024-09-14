package com.nacht.sn_0019;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/14 19:18
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode();
        virtual.next = head;
        /*快慢指针*/
        ListNode fast = virtual, slow = virtual;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        /*快指针走n步后, 慢指针出发*/
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        /*slow要删除它的next节点*/
        ListNode next = slow.next;
        slow.next = next.next;
        next.next = null;
        return virtual.next;
    }
}
