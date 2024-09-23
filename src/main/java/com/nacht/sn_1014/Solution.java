package com.nacht.sn_1014;

/**
 * @author Nacht
 * Created on 2024/9/23 16:39
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int currentMax = values[0];
        for (int j = 1; j < values.length; j++) {
            /*首先和前面的currentMax做一个相加, 取较大结果*/
            result = Math.max(result, currentMax + values[j] - j);
            /*然后记录一下(0, j)区间内values[i] + i的最大值*/
            currentMax = Math.max(currentMax, values[j] + j);
        }
        return result;
    }
}
