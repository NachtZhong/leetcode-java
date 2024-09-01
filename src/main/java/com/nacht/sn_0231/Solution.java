package com.nacht.sn_0231;

/**
 * @author Nacht
 * Created on 2024/8/31 20:47
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & n - 1) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(2));
    }
}
