package com.nacht.sn_0125;

/**
 * @author Nacht
 * Created on 2024/8/31 03:22
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l < r){
            while (l < s.length() && !Character.isLetterOrDigit(arr[l])){
                l++;
            }
            while (r >= 0 && !Character.isLetterOrDigit(arr[r])){
                r--;
            }
            if (l >= s.length() || r < 0 || l >= r){
                return true;
            }
            if (Character.toUpperCase(arr[l++]) != Character.toUpperCase(arr[r--])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(".,"));
    }
}
