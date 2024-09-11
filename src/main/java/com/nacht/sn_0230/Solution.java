package com.nacht.sn_0230;

import com.nacht.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 15:35
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /*搜索二叉树中序遍历是有序的, 我们利用这个特性, 遍历到第k个位置返回就行了*/
        List<Integer> list = new ArrayList<>();
        dfs(root, k, list);
        return list.get(list.size() - 1);
    }

    private void dfs(TreeNode root, int k, List<Integer> list) {
        /*找到了第k个数字*/
        if (list.size() == k){
            return;
        }
        /*当前节点为空, 不做处理*/
        if (root == null){
            return;
        }
        dfs(root.left, k, list);
        if (list.size() == k){
            return;
        }
        list.add(root.val);
        dfs(root.right, k, list);
    }

    public static void main(String[] args) {
        new Solution().kthSmallest(TreeNode.buildTree(new Integer[]{3,1,4,null,2}), 1);
    }
}
