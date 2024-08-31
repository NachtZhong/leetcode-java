package com.nacht.sn_0257;

import com.nacht.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nacht
 * Created on 2024/8/28 00:56
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root.left == null && root.right == null){
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> resultList = new ArrayList<>();
        dfs(root, resultList, new StringBuilder());
        return resultList;
    }

    private void dfs(TreeNode root, List<String> resultList, StringBuilder path) {
        int length = path.length();
        if (length > 0) {
            path.append("->");
        }
        path.append(root.val);
        /*走到底了, 添加到结果*/
        if (root.left == null && root.right == null){
            resultList.add(String.join("->", path));
        }
        if (root.left != null){
            dfs(root.left, resultList, path);
        }
        if (root.right != null){
            dfs(root.right, resultList, path);
        }
        path.setLength(length);
    }
}
