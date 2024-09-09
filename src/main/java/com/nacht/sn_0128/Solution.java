package com.nacht.sn_0128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/9/8 20:16
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        /*首先我们把数字丢到一个集合里面*/
        for (int num : nums){
            numSet.add(num);
        }
        int maxLength = 0;
        for(int num : numSet){
            /*找过的就滚一边儿去*/
            if (!numSet.contains(num - 1)){
                int currentLength = 1;
                int r = num + 1;
                while (numSet.contains(r)){
                    currentLength++;
                    r++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
