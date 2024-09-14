package com.nacht.sn_0173;

import com.nacht.util.TreeNode;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/14 11:18
 */
public class Solution {
    /*解法一: 直接中序遍历添加到*/
    static class BSTIterator {

        private List<Integer> nodeVals;
        private int current = 0;

        public BSTIterator(TreeNode root) {
            /*中序遍历, 顺序左中右, 首先我们把所有的左节点都放到队列里面*/
            nodeVals = new ArrayList<>();
            current = 0;
            inorder(root, nodeVals);
        }

        /**
         * 中序遍历树
         */
        private void inorder(TreeNode root, List<Integer> nodeVals) {
            if (root == null) return;
            inorder(root.left, nodeVals);
            nodeVals.add(root.val);
            inorder(root.right, nodeVals);
        }

        public int next() {
            return nodeVals.get(current++);
        }

        public boolean hasNext() {
            return current < nodeVals.size();
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{7,3,15,null,null,9,20});
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
    }
}
