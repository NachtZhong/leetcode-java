package com.nacht.sn_0107;

import com.nacht.util.TreeNode;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/10/4 03:24
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size -- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}
