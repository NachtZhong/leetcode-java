package com.nacht.sn_0290;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/8/31 08:27
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        char[] patternArr = pattern.toCharArray();
        if (patternArr.length != arr.length){
            return false;
        }
        String[] mappingArr = new String[127];
        Set<String> addedStr = new HashSet<>();
        for (int i = 0; i < patternArr.length; i++) {
            char current = patternArr[i];
            if (mappingArr[current] == null){
                if (addedStr.contains(arr[i])){
                    return false;
                }
                mappingArr[current] = arr[i];
                addedStr.add(arr[i]);
            }else{
                if (!mappingArr[current].equals(arr[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
