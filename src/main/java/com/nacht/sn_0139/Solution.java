package com.nacht.sn_0139;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/11 13:32
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        /*0index, 是true, 表明没有字符的时候是满足的*/
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String word : wordDict){
                /*如果i到起点的位置比word短, 那肯定是不匹配的, 跳过*/
                if (i < word.length()) continue;
                /*注意这里匹配的是i-word.length ~ i位置的子字符串是否和word相等*/
                if (s.startsWith(word, i - word.length()) && dp[i - word.length()]){
                    dp[i] = true;
                    /*只要匹配上一个就可以break掉这个位置了*/
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        new Solution().wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
}
