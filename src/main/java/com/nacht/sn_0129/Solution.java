package com.nacht.sn_0129;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/9 23:47
 */
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int base) {
        /*走到叶子节点了, 计算一下和加到结果里面*/
        if (root.left == null && root.right == null){
            sum += 10 * base;
            sum += root.val;
        }
        if (root.left != null){
            dfs(root.left, base * 10 + root.val);
        }
        if (root.right != null){
            dfs(root.right, base * 10 + root.val);
        }
    }
}
