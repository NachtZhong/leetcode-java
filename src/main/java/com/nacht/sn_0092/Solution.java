package com.nacht.sn_0092;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/6 11:13
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*虚拟节点, 方便做一致性处理*/
        ListNode virtual = new ListNode();
        virtual.next = head;
        ListNode prev = virtual;
        int current = 1;
        /*首先, 我们找到区间的前一个节点*/
        while (current++ < left){
            prev = prev.next;
        }
        /*用来遍历区间的节点*/
        /*区间最左边的节点*/
        ListNode lNode = prev.next;
        /*区间当前节点*/
        ListNode rNode = prev.next.next;
        while (current++ <= right){
            lNode.next = rNode.next;
            rNode.next = prev.next;
            prev.next = rNode;
            rNode = lNode.next;
        }
        return virtual.next;
    }
}
