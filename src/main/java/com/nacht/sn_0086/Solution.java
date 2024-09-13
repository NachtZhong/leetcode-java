package com.nacht.sn_0086;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/13 19:36
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode smallCurrent = small;
        ListNode largeCurrent = large;
        ListNode headCurrent = head;
        while (headCurrent != null){
            if (headCurrent.val >= x){
                largeCurrent.next = headCurrent;
                largeCurrent = largeCurrent.next;
                headCurrent = headCurrent.next;
                largeCurrent.next = null;
            }else{
                smallCurrent.next = headCurrent;
                smallCurrent = smallCurrent.next;
                headCurrent = headCurrent.next;
            }
        }
        smallCurrent.next = large.next;
        return small.next;
    }
}
