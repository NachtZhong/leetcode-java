package com.nacht.sn_0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 00:24
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> resultList = new ArrayList<>();
        int idx = 0;
        int[] current;
        while (idx < intervals.length){
            current = intervals[idx];
            while (idx < intervals.length && intervals[idx][0] <= current[1]){
                current[1] = Math.max(current[1], intervals[idx++][1]);
            }
            resultList.add(current);
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        new Solution().merge(new int[][]{
                {1,3},
                {2,6},
                {8, 10},
                {15, 18},
        });
    }
}
