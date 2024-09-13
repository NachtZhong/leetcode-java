package com.nacht.sn_0190;

/**
 * @author Nacht
 * Created on 2024/8/31 15:46
 */
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(964176192));
    }
}
