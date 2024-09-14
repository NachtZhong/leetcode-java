package com.nacht.sn_0025;

import com.nacht.util.ListNode;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/9/14 20:20
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        /*结果的头节点*/
        ListNode result = null;
        /*处理结果链表的当前节点*/
        ListNode current = null;
        /*下一段要处理链表的头节点*/
        ListNode nextHead = head;
        /*首先我们看一下链表有多长*/
        int length = 0;
        ListNode ptr = head;
        while (ptr != null){
            ptr = ptr.next;
            length++;
        }
        while (length >= k){
            ListNode tmp = nextHead;
            /*丢k个到栈里面*/
            for (int i = 0; i < k; i++) {
                stack.push(tmp);
                tmp = tmp.next;
                /*把下一段的头节点记录一下*/
                if (i == k - 1){
                    nextHead = tmp;
                }
            }
            /*从栈里面拿出来*/
            while (!stack.isEmpty()){
                ListNode node = stack.pop();
                node.next = null;
                if (result == null){
                    result = node; current = node;
                }else{
                    current.next = node;
                    current = current.next;
                }
            }
            length -= k;
        }
        if(current != null){
            current.next = nextHead;
        }
        return result == null ? head : result;
    }
}
