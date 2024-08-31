package com.nacht.sn_0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nacht
 * Created on 2024/8/27 19:13
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums){
            numList.add(num);
        }
        dfs(numList, 0, result);
        return result;
    }

    private void dfs(List<Integer> nums, int i, List<List<Integer>> result) {
        /*走到底将当前数组转为list添加到返回结果*/
        if (i >= nums.size() - 1){
            result.add(new ArrayList<>(nums));
            return;
        }
        /*交换其他数字到当前位置, 并一一对其dfs*/
        for (int j = i; j <= nums.size() - 1; j++) {
            swap(nums, i, j);
            dfs(nums, i + 1, result);
            swap(nums, i, j);
        }
    }

    private void swap(List<Integer> list, int i, int j){
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}
