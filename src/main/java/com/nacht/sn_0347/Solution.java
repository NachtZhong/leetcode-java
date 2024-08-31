package com.nacht.sn_0347;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/8/27 00:47
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*首先定义一个几把map*/
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, countMap.get(num));
        }
        /*遍历这个map, 丢到数组里面统计*/
        List<Integer>[] countArr = new List[max];
        countMap.forEach((key, value) -> {
            if(countArr[value - 1] == null){
                countArr[value - 1] = new ArrayList<>();
            }
            countArr[value - 1].add(key);
        });
        int[] result = new int[k];
        for (int i = countArr.length - 1; i >= 0; i--){
            if (countArr[i] == null){
                continue;
            }
            for (int num : countArr[i]){
                if (k > 0){
                    result[result.length - k--] = num;
                }else{
                    break;
                }
            }
            if (k <= 0){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
}
