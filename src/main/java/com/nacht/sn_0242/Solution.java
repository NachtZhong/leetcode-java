package com.nacht.sn_0242;

/**
 * @author Nacht
 * Created on 2024/9/2 02:30
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 =  t.toCharArray();
        if (arr1.length != arr2.length){
            return false;
        }
        int[] countArr = new int[26];
        for (char c : arr1){
            countArr[c - 'a'] ++;
        }
        for (char c : arr2){
            if (countArr[c - 'a'] -- == 0){
                return false;
            }
        }
        return true;
    }
}
