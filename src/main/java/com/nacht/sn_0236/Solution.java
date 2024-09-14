package com.nacht.sn_0236;

import com.nacht.util.TreeNode;

/**
 * @author Nacht
 * Created on 2024/9/14 19:38
 */
public class Solution {
    /*当前已经找到的结果*/
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postorderFindCommonAncestor(root, p.val, q.val);
        return result;
    }

    /**
     * 后序遍历找最近公共祖先
     * @param root 当前子树根节点
     * @param val1 节点值1
     * @param val2 节点值2
     * @return 当前已经匹配到的节点数
     */
    private int postorderFindCommonAncestor(TreeNode root, int val1, int val2) {
        /*已经找到, 或者走到了叶子节点, 不需要再处理, 直接返回0*/
        if (result != null || root == null){
            return 0;
        }
        int leftMatchCount = postorderFindCommonAncestor(root.left, val1, val2);
        int rightMatchCount = postorderFindCommonAncestor(root.right, val1, val2);
        if (result != null){
            return 0;
        }
        /*左右子树加起来match了两个, 当前节点就是结果*/
        if (leftMatchCount + rightMatchCount == 2){
            result = root;
            return 2;
        }
        /*左右子树match了一个, 且当前节点match了, 当前节点也是结果*/
        else if (leftMatchCount + rightMatchCount == 1 && (root.val == val1 || root.val == val2)) {
            result = root;
            return 2;
        }
        /*其他情况, 返回已经match的个数*/
        return root.val == val1 || root.val == val2 ? leftMatchCount + rightMatchCount + 1 : leftMatchCount + rightMatchCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lowestCommonAncestor(TreeNode.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(4)));
    }
}
