package com.nacht.sn_0151;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nacht
 * Created on 2024/8/30 23:31
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int l = s.length() - 1, r = s.length() - 1;
        while (l >= 0){
            while (l >= 0 && s.charAt(l) != ' '){
                l--;
            }
            result.append(s, l + 1, r + 1);
            result.append(" ");
            r = l;
            while (r >= 0 && s.charAt(r) == ' '){
                r--;
            }
            l = r;
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String s = "EPY2giL";
        System.out.println(new Solution().reverseWords(s));
    }
}
