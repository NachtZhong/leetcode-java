package com.nacht.sn_0763;

import java.util.*;

/**
 * @author Nacht
 * Created on 2023/12/13 14:05
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] rightBorder = new int[26];
        for (int i = 0; i < s.length(); i++) {
            rightBorder[s.charAt(i) - 'a'] = i;
        }
        int left = 0, right = rightBorder[s.charAt(left) - 'a'];
        int segmentLength = 1;
        List<Integer> result = new ArrayList<>();
        while (left < s.length()){
            /*左右相交, 输出一段*/
            if(left == right){
                result.add(segmentLength);
                segmentLength = 1;
                if(left + 1 < s.length()){
                    right = rightBorder[s.charAt(left + 1) - 'a'];
                }
            }else{
                char c = s.charAt(left);
                right = Math.max(rightBorder[c - 'a'], right);
                segmentLength++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("eaaaabaaec"));
    }
}
