package com.nacht.sn_0070;

/**
 * @author Nacht
 * Created on 2024/9/9 00:19
 */
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            b = a;
            a = sum;
        }
        return sum;
    }
}
