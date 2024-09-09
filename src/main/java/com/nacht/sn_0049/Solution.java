package com.nacht.sn_0049;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/9/2 04:12
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs){
            String key = calcKey(str);
            groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>(groupMap.values());
        return result;
    }
    private String calcKey(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
