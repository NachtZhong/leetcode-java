package com.nacht.sn_1446;

/**
 * @author Nacht
 * Created on 2024/10/4 03:55
 */
public class Solution {
    public int maxPower(String s) {
        char[] arr = s.toCharArray();
        int max = 1;
        int current = 1;
        char prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev){
                current ++;
                max = Math.max(max, current);
            }else{
                prev = arr[i];
                current = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPower("aaabbbbc"));
    }
}
