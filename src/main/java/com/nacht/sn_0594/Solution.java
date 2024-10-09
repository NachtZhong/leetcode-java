package com.nacht.sn_0594;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/10/6 00:15
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }
        int result = 0;
        for (int num : nums){
            if (countMap.containsKey(num) && countMap.containsKey(num + 1)){
                result = Math.max(countMap.get(num) + countMap.get(num + 1), result);
            }
        }
        return result;
    }
}
