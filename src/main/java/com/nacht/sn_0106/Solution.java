package com.nacht.sn_0106;

import com.nacht.util.PrettyPrintUtil;
import com.nacht.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/9/12 17:00
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*同样的, 我们记录一下中序遍历中值和idx的映射*/
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return buildTree(postorder, inorderIdxMap, postorder.length - 1, 0, postorder.length - 1);
    }

    /**
     * 递归构建二叉树
     * @param postorder 后序遍历的数组
     * @param inorderIdxMap 中序遍历的值 -> idx映射关系
     * @param rootIdx 当前子树根节点在后序遍历数组中的idx
     * @param l 当前子树在中序遍历中的左边界
     * @param r 当前子树在中序遍历中的右边界
     * @return
     */
    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderIdxMap, int rootIdx, int l, int r) {
        /*根节点的值*/
        int rootVal = postorder[rootIdx];
        /*首先我们构建根节点*/
        TreeNode root = new TreeNode(rootVal);
        /*根节点在中序遍历中的idx*/
        int inorderRootIdx = inorderIdxMap.get(rootVal);
        /*右子树长度*/
        int rightLength = r > inorderRootIdx ? r - inorderRootIdx : 0;
        /*右子树根节点在后序遍历数组中的idx, 只有右子树长度不为0的时候有意义*/
        int rightTreeRootIdx = rootIdx - 1;
        /*左子树长度*/
        int leftLength = inorderRootIdx > l ? inorderRootIdx - l : 0;
        /*左子树根节点在后序遍历数组中的idx, 只有左子树长度不为0的时候有意义*/
        int leftTreeRootIdx = rootIdx - 1 - rightLength;
        if (leftLength > 0){
            root.left = buildTree(postorder, inorderIdxMap, leftTreeRootIdx, l, inorderRootIdx - 1);
        }
        if (rightLength > 0){
            root.right = buildTree(postorder, inorderIdxMap, rightTreeRootIdx, inorderRootIdx + 1, r);
        }
        return root;
    }

    public static void main(String[] args) {
        PrettyPrintUtil.printBinaryTree(new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
}
