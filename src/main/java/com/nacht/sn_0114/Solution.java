package com.nacht.sn_0114;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/11 01:00
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        doFlatten(root);
    }

    public TreeNode doFlatten(TreeNode root){
        if (root.left == null && root.right == null){
            return root;
        }
        TreeNode left = root.left, right = root.right;
        root.left = null;
        /*左子树为空的情况, 直接将右子树转为链表*/
        if (left == null){
            return doFlatten(right);
        }
        /*右子树为空的情况, 将root右节点接到左子树, 然后将左子树转为链表*/
        else if (right == null){
            root.right = left;
            return doFlatten(left);
        }
        /*左右子树都不为空*/
        else{
            root.right = left;
            TreeNode tail = doFlatten(left);
            tail.right = right;
            tail = doFlatten(right);
            return tail;
        }
    }
}
