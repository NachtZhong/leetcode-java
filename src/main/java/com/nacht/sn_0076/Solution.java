package com.nacht.sn_0076;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Nacht
 * Created on 2024/8/22 03:35
 */
public class Solution {
    public String minWindow(String s, String t) {
        /*首先遍历t, 记录字母个数*/
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCharCount.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        Map<Character, Integer> sCharCount = new HashMap<>();
        /*当前范围内包含的字母数量(去重后的), 比如t里面有两个a, 那么必须范围内有两个a才会计数1*/
        int currentCount = 0;
        String minRangeStr = "";
        /*初始指针*/
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if(tCharCount.containsKey(rightChar)){
                sCharCount.compute(rightChar, (k, v) -> v == null ? 1 : v + 1);
                if (Objects.equals(sCharCount.get(rightChar), tCharCount.get(rightChar))){
                    currentCount++;
                    /*如果已经全部包含了, 走左指针*/
                    while (currentCount == tCharCount.size()){
                        char leftChar = s.charAt(left);
                        left++;
                        if (tCharCount.containsKey(leftChar)){
                            sCharCount.put(leftChar, sCharCount.get(leftChar) - 1);
                            /*减去这个不满足了, 就输出一轮*/
                            if (sCharCount.get(leftChar) < tCharCount.get(leftChar)){
                                currentCount--;
                                String currentStr = s.substring(left - 1, right + 1);
                                minRangeStr = minRangeStr.isEmpty() ?  currentStr : currentStr.length() > minRangeStr.length() ? minRangeStr : currentStr;
                                break;
                            }
                        }

                    }
                }
            }
        }
        return minRangeStr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("A", "AA"));
    }
}
