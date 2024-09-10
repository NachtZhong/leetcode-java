package com.nacht.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2023/11/20 19:00
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    // 基于层序遍历的 Integer 数组的构造方法
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;  // 如果数组为空或者根节点是 null
        }

        TreeNode root = new TreeNode(array[0]);  // 创建根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  // 将根节点加入队列

        int i = 1;  // 从第二个元素开始处理（索引 1）

        while (i < array.length) {
            TreeNode current = queue.poll();  // 从队列中取出当前节点

            // 处理左子节点
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            i++;

            // 处理右子节点
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;  // 返回构建的根节点
    }

    // 方便测试：层序遍历打印树
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}