package com.nacht.sn_0222;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/14 18:21
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
