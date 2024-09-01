package com.nacht.sn_0191;

/**
 * @author Nacht
 * Created on 2024/8/31 14:37
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0){
            int remainder = n % 2;
            if (remainder == 1){
                count += 1;
            }
            n /= 2;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n > 0){
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(2147483645));
    }
}
