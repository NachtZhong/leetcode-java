package com.nacht.sn_0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/8/28 13:01
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (int num : nums){
            numList.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(numList, 0, result);
        return result;
    }

    private void dfs(List<Integer> numList, int current, List<List<Integer>> result) {
        if (numList.size() == current){
            result.add(new ArrayList<>(numList));
            return;
        }
        boolean[] addedNumFlag = new boolean[20];
        for (int i = current; i < numList.size(); i++) {
            /*添加过同样的数字到这里, 就不做处理*/
            int target = numList.get(i);
            if (addedNumFlag[target + 10]){
                continue;
            }
            swap(numList, current, i);
            addedNumFlag[target + 10] = true;
            dfs(numList, current + 1, result);
            swap(numList, current, i);
        }
    }

    private static void swap(List<Integer> numList, int current, int i) {
        int tmp = numList.get(current);
        numList.set(current, numList.get(i));
        numList.set(i, tmp);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,2, 3}));
    }
}
