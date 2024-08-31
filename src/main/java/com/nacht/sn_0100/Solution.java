package com.nacht.sn_0100;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/8/31 10:55
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
