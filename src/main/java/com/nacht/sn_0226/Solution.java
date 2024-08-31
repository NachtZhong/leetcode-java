package com.nacht.sn_0226;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/8/31 10:58
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
