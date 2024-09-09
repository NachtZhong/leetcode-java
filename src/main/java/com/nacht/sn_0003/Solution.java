package com.nacht.sn_0003;

/**
 * @author Nacht
 * Created on 2024/9/9 09:23
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0){
            return 0;
        }
        int[] countArr = new int[128];
        int maxLength = 0;
        int l = 0, r = 0;
        while (r < arr.length){
            char currentChar = arr[r];
            countArr[currentChar] += 1;
            if (countArr[currentChar] > 1){
                /*右指针走到当前窗口内有一个重复了, 记录一下长度*/
                maxLength = Math.max(maxLength, r - l);
                /*走左指针, 让其不重复*/
                while (l < r && countArr[currentChar] > 1){
                    countArr[arr[l]] -= 1;
                    l++;
                }
            } else if (r == arr.length - 1) {
                /*走到底了还没有重复, 记录一下当前的最大长度*/
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }
}
