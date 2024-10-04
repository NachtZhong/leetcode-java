package com.nacht.sn_1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/10/4 19:29
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr1 = new int[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        Arrays.sort(arr1);
        Map<Integer, Integer> orderMap = new HashMap<>();
        int currentRank = 1;
        for (int num : arr1){
            if (orderMap.containsKey(num)) continue;
            orderMap.put(num, currentRank++);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = orderMap.get(arr[i]);
        }
        return arr;
    }
}
