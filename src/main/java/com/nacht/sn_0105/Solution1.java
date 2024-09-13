package com.nacht.sn_0105;

import com.nacht.util.PrettyPrintUtil;
import com.nacht.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/9/12 16:00
 */
public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*因为我们有基于根节点值定位中序遍历数组中位置的操作, 提前将其放到一个map里面方便按值定位index*/
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, 0, preorder.length - 1);
    }

    /**
     * 递归构建二叉树
     * @param preorder 前序遍历
     * @param inorderMap 中序遍历值->idx的映射
     * @param rootIdx 根节点在前序遍历数组中的idx
     * @param l 当前子树在中序遍历中的左边界
     * @param r 当前子树在中序遍历中的右边界
     */
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int rootIdx, int l, int r) {
        /*根节点的值*/
        int rootVal = preorder[rootIdx];
        /*构建根节点*/
        TreeNode root = new TreeNode(rootVal);
        /*找到根节点在中序遍历中的位置*/
        int inorderIdx = inorderMap.get(rootVal);
        /*左子树的长度*/
        int leftTreeLength = inorderIdx > l ? inorderIdx - l : 0;
        /*左子树根节点的idx(只有左子树不为空的时候才有意义)*/
        int leftTreeRootIdx = rootIdx + 1;
        /*右子树的长度*/
        int rightTreeLength = r > inorderIdx ? r - inorderIdx : 0;
        /*右子树根节点的idx(只有右子树不为空的时候才有意义)*/
        int rightTreeRootIdx = rootIdx + leftTreeLength + 1;
        if (leftTreeLength > 0){
            root.left = buildTree(preorder, inorderMap, leftTreeRootIdx, l, inorderIdx - 1);
        }
        if (rightTreeLength > 0){
            root.right = buildTree(preorder, inorderMap, rightTreeRootIdx, inorderIdx + 1, r);
        }
        return root;
    }

    public static void main(String[] args) {
        PrettyPrintUtil.printBinaryTree(new Solution1().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
