package com.nacht.sn_0524;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/8/25 20:19
 */
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String ss : dictionary){
            int sLeft = 0, ssLeft = 0;
            while (sLeft < s.length() && ssLeft < ss.length()){
                if (s.charAt(sLeft++) == ss.charAt(ssLeft)){
                    ssLeft++;
                }
            }
            if (ssLeft == ss.length()){
                if (ss.length() >= result.length()) {
                    if(ss.length() > result.length()){
                        result = ss;
                    }else if (ss.compareTo(result) < 0){
                        result = ss;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestWord("appleessds", Arrays.asList("less")));
    }
}
