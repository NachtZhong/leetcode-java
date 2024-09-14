package com.nacht.sn_0173;

import com.nacht.util.TreeNode;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/9/14 12:10
 */
public class Solution1 {
    /*解法二: 借助栈进行中序遍历*/
    /*实际ac效果不如解法一, 还是简单点直接先存起来*/
    class BSTIterator {
        TreeNode current;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            current = root;
            stack = new Stack<>();
        }

        public int next() {
            /*当前节点不为null, 就继续push左节点*/
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            /*处理栈顶的元素, 也就是最左的节点*/
            current = stack.pop();
            /*获取到当前元素*/
            int value = current.val;
            /*下一个要处理的节点是当前节点的右节点*/
            current = current.right;
            return value;
        }

        public boolean hasNext() {
            return current != null || !stack.isEmpty();
        }
    }
}
