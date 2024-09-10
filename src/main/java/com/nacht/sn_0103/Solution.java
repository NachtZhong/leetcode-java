package com.nacht.sn_0103;

import com.nacht.util.TreeNode;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/11 01:13
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        /*非得恶心一下是吧*/
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list =new LinkedList<>();
            while (size-- > 0){
                TreeNode current = queue.poll();
                /*非reverse就正常顺序插, reverse就头插将其顺序倒过来*/
                if (!reverse){
                    list.addLast(current.val);
                }else{
                    list.addFirst(current.val);
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(list);
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{1,2,3,4,null,null,5});
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
