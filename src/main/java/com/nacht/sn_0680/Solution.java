package com.nacht.sn_0680;

/**
 * @author Nacht
 * Created on 2024/8/25 17:00
 */
public class Solution {
    public boolean validPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        /*左右指针*/
        int left = 0, right = s.length() - 1;
        /*是否曾重置*/
        boolean hasBeenRest = false;
        /*重置指针记录*/
        int resetLeft = 0, resetRight = 0;
        /*尝试跳过次数*/
        int skipCount = 0;
        while (left <= right){
            if (s.charAt(left) == s.charAt(right)){
                left++; right--;
            }else{
                if(skipCount == 0){
                    /*第一次碰到不相等的时候, 记录当前的左右指针*/
                    resetLeft = left;
                    resetRight = right;
                    /*先跳右指针*/
                    right--;
                    skipCount++;
                }else{
                    /*第二次碰到不相等, 判断是否reset过, 如果reset过, 返回false, 否则reset一次, 跳左指针*/
                    if(hasBeenRest){
                        return false;
                    }else{
                        left = ++resetLeft;
                        right = resetRight;
                        hasBeenRest = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abc"));
    }
}
