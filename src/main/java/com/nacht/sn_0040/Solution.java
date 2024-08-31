package com.nacht.sn_0040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/8/28 14:20
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        /*按照题意, 数组里面每个数都不会大于50*/
        int[] countArr = new int[51];
        /*不重复的数字个数*/
        int totalNumCount = 0;
        for (int num : candidates){
            /*统计一下不重复的数字个数*/
            if (countArr[num] == 0){
                totalNumCount++;
            }
            countArr[num] += 1;
        }
        /*arr记录的是原数组数字和对应的个数*/
        int[][] arr = new int[totalNumCount][2];
        int current = 0;
        for (int i = 1; i < countArr.length; i++) {
            if (countArr[i] != 0){
                arr[current++] = new int[]{i, countArr[i]};
            }
        }
        int[] selectArr = new int[totalNumCount];

        dfs(arr, result, 0, target, selectArr);
        return result;
    }

    private void dfs(int[][] arr, List<List<Integer>> result, int current, int target, int[] selectArr) {
        if (target < 0 || current >= arr.length){
            return;
        }
        if (target == 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < selectArr.length; i++) {
                if (selectArr[i] > 0){
                    for (int j = 0; j < i; j++) {
                        list.add(arr[i][0]);
                    }
                }
            }
            result.add(list);
            return;
        }
        while (selectArr[current] <= arr[current][1]){
            dfs(arr, result, current + 1, target - selectArr[current] * arr[current][0], selectArr);
            selectArr[current] += 1;
        }
        selectArr[current] -= 1;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
