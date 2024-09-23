package com.nacht.sn_1184;

import com.nacht.sn_0079.Solution1;

/**
 * @author Nacht
 * Created on 2024/9/16 12:38
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start < destination) {
                if (i >= start && i < destination) {
                    sum1 += distance[i];
                } else {
                    sum2 += distance[i];
                }
            }else{
                if (i >= start || i < destination) {
                    sum1 += distance[i];
                } else {
                    sum2 += distance[i];
                }
            }
        }
        return sum1 == 0 ? sum2 : sum2 == 0 ? sum1 : Math.min(sum1, sum2);
    }

    public static void main(String[] args) {
        new Solution().distanceBetweenBusStops(new int[]{1,2,3,4}, 0,3);
    }
}
