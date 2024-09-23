package com.nacht.sn_1491;

/**
 * @author Nacht
 * Created on 2024/9/23 18:27
 */
public class Solution {
    public double average(int[] salary) {
        double min = Integer.MAX_VALUE, max = 0, sum = 0;
        for (int num : salary){
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
