package com.nacht.sn_0111;

import com.nacht.util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2024/10/3 20:03
 */
public class Solution {
    public int minDepth(TreeNode root) {
        int currentHeight = 1;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return currentHeight;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            currentHeight++;
        }
        return currentHeight;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDepth(TreeNode.buildTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }
}
