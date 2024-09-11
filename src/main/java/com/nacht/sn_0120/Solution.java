package com.nacht.sn_0120;

import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 17:01
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        int size = triangle.size();
        for (int level = 0; level < size; level++) {
            if (level == 0){
                if (level == size - 1) result = Math.min(triangle.get(0).get(0), result);
                continue;
            }
            List<Integer> currentList = triangle.get(level);
            for (int i = 0; i < currentList.size(); i++) {
                int currentMin;
                int currentValue = currentList.get(i);
                if (i == 0){
                    currentMin = triangle.get(level - 1).get(i) + currentValue;
                } else if (i == currentList.size() - 1) {
                    currentMin = triangle.get(level - 1).get(i - 1) + currentValue;
                }else{
                    currentMin = Math.min(triangle.get(level - 1).get(i), triangle.get(level - 1).get(i - 1)) + currentValue;
                }
                if (level == size - 1){
                    result = Math.min(result, currentMin);
                }else{
                    currentList.set(i, currentMin);
                }
            }
        }
        return result;
    }
}
