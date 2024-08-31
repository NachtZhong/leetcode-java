package com.nacht.sn_0112;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/8/31 12:13
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        int value = root.val;
        /*叶子节点*/
        if (root.left == null && root.right == null){
            return value == targetSum;
        }
        if (root.left == null){
            return dfs(root.right, targetSum - value);
        }
        if (root.right == null){
            return dfs(root.left, targetSum - value);
        }
        return dfs(root.left, targetSum - value) || dfs(root.right, targetSum - value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(new Solution().hasPathSum(root, 1));
    }

}
