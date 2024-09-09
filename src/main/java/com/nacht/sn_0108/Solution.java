package com.nacht.sn_0108;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/9 11:53
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i == j){
            return new TreeNode(nums[i]);
        }
        if (i > j){
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, i, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, j);
        return root;
    }
}
