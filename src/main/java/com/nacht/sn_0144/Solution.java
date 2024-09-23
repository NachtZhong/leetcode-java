package com.nacht.sn_0144;

import com.nacht.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/23 18:54
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
