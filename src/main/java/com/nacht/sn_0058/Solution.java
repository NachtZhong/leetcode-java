package com.nacht.sn_0058;

/**
 * @author Nacht
 * Created on 2024/8/30 22:58
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == ' '){
            i--;
        }
        int result = 0;
        while (i >= 0 && Character.isLetter(s.charAt(i--))){
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello  fuck"));
    }
}
