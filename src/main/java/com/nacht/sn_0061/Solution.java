package com.nacht.sn_0061;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/9/11 16:10
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        /*没有节点, 或者只有一个节点, 直接返回*/
        if (head == null || head.next == null){
            return head;
        }
        /*首先, 我们确定链表的长度和尾结点*/
        ListNode tail = head;
        int size = 1;
        while (tail.next != null){
            size++;
            tail = tail.next;
        }
        /*实际要移动的位置数量*/
        k %= size;
        if (k == 0){
            return head;
        }
        /*尾结点接到原来的头结点*/
        tail.next = head;
        /*尾结点再走size-k步, 就是新的尾结点*/
        int step = size - k;
        while (step-- > 0){
            tail = tail.next;
        }
        /*新的头结点*/
        head = tail.next;
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution().rotateRight(head, 3);
    }
}
