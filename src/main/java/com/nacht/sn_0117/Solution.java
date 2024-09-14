package com.nacht.sn_0117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2024/9/14 13:57
 */
public class Solution {
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
        Queue<Node> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            while (size-- > 0){
                Node current = queue.poll();
                if (prev != null){
                    prev.next = current;
                }
                prev = current;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return root;
    }
}
