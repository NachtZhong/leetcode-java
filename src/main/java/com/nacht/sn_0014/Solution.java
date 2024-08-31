package com.nacht.sn_0014;

/**
 * @author Nacht
 * Created on 2024/8/30 23:05
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int k = 0;
        while (true){
            if (k >= strs[0].length()){
                return result.toString();
            }
            char tmp = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if (k >= strs[i].length() || strs[i].charAt(k) != tmp){
                    return result.toString();
                }
            }
            result.append(tmp);
            k++;
        }
    }
}
