package com.nacht.sn_0082;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/6 00:45
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /*为了统一处理, 我们搞个虚拟的头结点*/
        ListNode virtual = new ListNode();
        ListNode current = virtual;
        ListNode next = head;
        while (next != null){
            /*跳过这些重复的逼节点*/
            if (next.next != null && next.val == next.next.val){
                int val = next.val;
                while (next != null && next.val == val){
                    next = next.next;
                }
                if (next == null){
                    current.next = next;
                }
            }else{
                current.next = next;
                current = current.next;
                next = next.next;
            }
        }
        return virtual.next;
    }
}
