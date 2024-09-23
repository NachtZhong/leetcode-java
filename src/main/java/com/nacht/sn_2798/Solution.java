package com.nacht.sn_2798;

/**
 * @author Nacht
 * Created on 2024/9/23 17:00
 */
public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;
        for (int num : hours){
            if (num >= target) result++;
        }
        return result;
    }
}
