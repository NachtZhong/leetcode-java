package com.nacht.sn_0455;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2023/12/10 13:07
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        if (s.length == 0){
            return result;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        while (gIndex <= g.length - 1 && sIndex <= s.length - 1){
            if (s[sIndex] >= g[gIndex]){
                result++;
                sIndex++;
                gIndex++;
            }else{
                sIndex++;
            }
        }
        return result;
    }
}
