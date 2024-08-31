package com.nacht.sn_0077;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/8/27 19:59
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(n, k, k, 1, new ArrayList<>(), resultList);
        return resultList;
    }

    /**
     * @param n 数字范围
     * @param k 全部需要添加的数字数量
     * @param remainCount 需要添加的数字数量
     * @param currentPos 当前走到的位置
     * @param addedNums 已经添加的数字
     * @param resultList 结果集
     */
    private void dfs(int n, int k, int remainCount, int currentPos, List<Integer> addedNums, List<List<Integer>> resultList) {
        /*剩余的数字不够了, 返回*/
        if (n - currentPos + 1 < remainCount){
            return;
        }
        /*添加的数字够了, 返回*/
        if (addedNums.size() == k){
            resultList.add(new ArrayList<>(addedNums));
            return;
        }
        /*添加当前数字*/
        addedNums.add(currentPos);
        dfs(n, k, remainCount - 1, currentPos + 1, addedNums, resultList);
        /*不添加当前数字*/
        addedNums.remove(addedNums.size() - 1);
        dfs(n, k, remainCount, currentPos + 1, addedNums, resultList);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(5, 3));
    }
}
