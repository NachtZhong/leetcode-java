package com.nacht.sn_0461;

/**
 * @author Nacht
 * Created on 2024/9/1 11:10
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n > 0){
            n &= n - 1;
            count++;
        }
        return count;
    }
}
