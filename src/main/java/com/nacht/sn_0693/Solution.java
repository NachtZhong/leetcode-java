package com.nacht.sn_0693;

/**
 * @author Nacht
 * Created on 2024/9/1 11:37
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int b = n ^ (n >>> 1);
        return (b ^ (b + 1)) == 0;
    }
}
