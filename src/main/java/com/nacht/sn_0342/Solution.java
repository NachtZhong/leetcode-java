package com.nacht.sn_0342;

/**
 * @author Nacht
 * Created on 2024/8/31 20:54
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return ((n & (n - 1)) == 0) && n % 3 == 1;
    }
}
