package com.nacht.sn_0219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/8/31 09:26
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current)){
                if (i - map.get(current) <= k){
                    return true;
                }
            }
            map.put(current, i);
        }
        return false;
    }
}
