package com.nacht.sn_0530;

import com.nacht.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/9 10:25
 */
public class Solution {
    int minDiff;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }

    /**
     * 中序遍历
     */
    private void inorderTraversal(TreeNode root) {
        if (root.left != null){
            inorderTraversal(root.left);
        }
        if (prev != null){
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;

        if (root.right != null){
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;
        node.left = node1;
        node.right  = node2;
        System.out.println(new Solution().getMinimumDifference(node));
    }
}
