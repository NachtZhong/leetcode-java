package com.nacht.sn_0098;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/10 00:36
 */
public class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null){
            boolean result = prev == null || root.val > prev;
            prev = root.val;
            return result;
        }
        boolean result = true;
        if (root.left != null){
            result = isValidBST(root.left);
        }
        result = result && (prev == null || root.val > prev);
        prev = root.val;
        if (root.right != null){
            result = result && isValidBST(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        node.left = node1;
        new Solution().isValidBST(node);
    }
}
