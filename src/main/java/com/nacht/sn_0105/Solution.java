package com.nacht.sn_0105;

import com.nacht.util.PrettyPrintUtil;
import com.nacht.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2023/11/20 19:00
 */
public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderIndexMap, 0, 0, preorder.length - 1);
    }

    /**
     *
     * @param preorder 前序遍历数组(全量)
     * @param inorderIndexMap 中序遍历的索引
     * @param rootPreOrderIndex 根节点在前序遍历数组中的索引
     * @param left 该子树在中序遍历数组中的左边界
     * @param right 该子树在中序遍历数组中的右边界
     * @return
     */
    public static TreeNode dfs(
            int[] preorder,
            Map<Integer, Integer> inorderIndexMap,
            int rootPreOrderIndex,
            int left,
            int right
            ) {
        if(left > right){
            return null;
        }
        // 初始化根节点
        TreeNode root = new TreeNode(preorder[rootPreOrderIndex]);
        // 查询根节点在中序遍历中的index
        int rootInorderIndex = inorderIndexMap.get(preorder[rootPreOrderIndex]);
        //左子树在前序遍历数组中的index
        int leftTreeRootPreOrderIndex = rootPreOrderIndex + 1;
        //左子树在中序遍历中的左边界
        int leftTreeLeftBorder = left;
        //左子树在中序遍历中的右边界
        int leftTreeRightBorder = rootInorderIndex - 1;
        //右子树在前序遍历数组中的index(左子树index + 左子树的长度)
        int rightTreeRootPreOrderIndex = leftTreeRootPreOrderIndex + rootInorderIndex - leftTreeLeftBorder;
        // 右子树在中序遍历中的左边界
        int rightTreeLeftBorder = rootInorderIndex + 1;
        //右子树在中序遍历中的右边界
        int rightTreeRightBorder = right;
        // 子问题：构建左子树
        root.left = dfs(preorder, inorderIndexMap, leftTreeRootPreOrderIndex, leftTreeLeftBorder, leftTreeRightBorder);
        // 子问题：构建右子树
        root.right = dfs(preorder, inorderIndexMap, rightTreeRootPreOrderIndex, rightTreeLeftBorder, rightTreeRightBorder);
        return root;
    }

    public static void main(String[] args) {
        PrettyPrintUtil.printBinaryTree(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

}