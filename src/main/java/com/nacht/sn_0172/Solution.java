package com.nacht.sn_0172;

/**
 * @author Nacht
 * Created on 2024/9/10 19:57
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            n /= 5;
            count += n;
        }
        return count;
    }
}
