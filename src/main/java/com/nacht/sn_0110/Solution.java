package com.nacht.sn_0110;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/10/3 19:58
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return recursive(root) != -1;
    }
    public int recursive(TreeNode root){
        if (root == null) return 0;
        int leftHeight = recursive(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = recursive(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
