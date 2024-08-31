package com.nacht.sn_0142;

/**
 * @author Nacht
 * Created on 2023/12/25 21:43
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if ( head == null){
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null){
                return null;
            }
            if (fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
