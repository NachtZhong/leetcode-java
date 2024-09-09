package com.nacht.sn_0201;

/**
 * @author Nacht
 * Created on 2024/9/6 20:27
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left){
            right &= right - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(2147483646, 2147483647));
    }
}
