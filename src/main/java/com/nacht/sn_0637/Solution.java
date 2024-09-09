package com.nacht.sn_0637;

import com.nacht.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2024/9/9 10:14
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            double sum = 0;
            /*当前层的数量*/
            double nodeCount = queue.size(), currentLevelNodeCount = queue.size();
            while (currentLevelNodeCount > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                currentLevelNodeCount--;
            }
            result.add(sum / nodeCount);
        }
        return result;
    }
}
