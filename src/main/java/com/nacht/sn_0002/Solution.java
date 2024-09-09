package com.nacht.sn_0002;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/6 00:31
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null){
            int add1 = l1 == null ? 0 : l1.val;
            int add2 = l2 == null ? 0 : l2.val;
            int sum = add1 + add2 + carry;
            current.val = sum % 10;
            carry = sum > 9 ? 1 : 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 != null || l2 != null || carry == 1) current.next = new ListNode(1); current = current.next;
        }
        return result;
    }
}
