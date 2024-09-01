package com.nacht.sn_0371;

/**
 * @author Nacht
 * Created on 2024/9/1 23:41
 */
public class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0){
            int prev = sum;
            sum ^= carry;
            carry = (prev & carry) << 1;
        }
        return sum;
    }
}
