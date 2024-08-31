package com.nacht.sn_0633;

/**
 * @author Nacht
 * Created on 2024/8/22 04:23
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (int) Math.sqrt(c);
        while (left <= right){
            if ((left * left + right * right) == c){
                return true;
            } else if ((left * left + right * right) < c) {
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(2147483600));
    }
}
