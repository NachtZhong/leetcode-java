package com.nacht.sn_0117;

/**
 * @author Nacht
 * Created on 2024/9/14 15:15
 */
public class Solution1 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        /*用来指向每一层当前处理到的水平链表的节点的指针*/
        Node current = root;
        while (current != null){
            /*下一层水平链表的头节点*/
            Node nextHead = null;
            /*下一层水平链表处理的前置节点*/
            Node prev = null;
            while (current != null){
                if (current.left != null) {
                    if (prev == null){
                        nextHead = current.left;
                    }else{
                        prev.next = current.left;
                    }
                    prev = current.left;
                }
                if (current.right != null) {
                    if (prev == null){
                        nextHead = current.right;
                    }else{
                        prev.next = current.right;
                    }
                    prev = current.right;
                }
                current = current.next;
            }
            /*把current指到下一层水平链表的头结点*/
            current = nextHead;
        }
        return root;
    }
}
