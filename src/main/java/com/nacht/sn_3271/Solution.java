package com.nacht.sn_3271;

/**
 * @author Nacht
 * Created on 2024/9/7 16:55
 */
public class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        char[] arr = s.toCharArray();
        int current = 0;
        while (current < arr.length){
            int tmp = 0, i = 0;
            while (i++ < k){
                tmp += arr[current] - 'a';
                current++;
            }
            result.append((char) ('a' + tmp % 26));
        }
        return result.toString();
    }

}
