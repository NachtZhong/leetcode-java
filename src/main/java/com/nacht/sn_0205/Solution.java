package com.nacht.sn_0205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/8/31 08:15
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] charMapping = new char[127];
        boolean[] hasBeenAdd = new boolean[127];
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            char sChar = c1[i];
            char tChar = c2[i];
            /*没映射过的情况*/
            if (charMapping[sChar] == '\0'){
                /*目标字符已经被添加过了, 不能再添加*/
                if (hasBeenAdd[tChar]){
                    return false;
                }
                charMapping[sChar] = tChar;
                hasBeenAdd[tChar] = true;
            }else{
                if (charMapping[sChar] != tChar){
                    return false;
                }
            }
        }
        return true;
    }
}
