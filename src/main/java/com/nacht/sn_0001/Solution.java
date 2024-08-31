package com.nacht.sn_0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2023/11/19 01:22
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (!idxMap.containsKey(num)){
                idxMap.put(nums[i], i);
            }else{
                return new int[]{idxMap.get(nums[i]), i};
            }
        }
        return new int[]{};
    }

}
