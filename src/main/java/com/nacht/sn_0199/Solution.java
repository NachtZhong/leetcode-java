package com.nacht.sn_0199;

import com.nacht.util.TreeNode;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/10 00:50
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (depth == result.size()) result.add(root.val);
        if (root.right != null) dfs(root.right, result, depth + 1);
        if (root.left != null) dfs(root.left, result, depth + 1);
    }
}
