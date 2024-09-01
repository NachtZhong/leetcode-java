package com.nacht.mst.sn_0501;

/**
 * @author Nacht
 * Created on 2024/9/1 22:56
 */
public class Solution {
    public int insertBits(int N, int M, int i, int j) {
        N &= ~ ((((((1 << j) - 1) << 1) + 1) >> i) << i);
        return N ^ (M << i);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().insertBits(0, 31, 0, 4));
    }
}
