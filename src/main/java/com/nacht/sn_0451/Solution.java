package com.nacht.sn_0451;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/8/26 18:35
 */
public class Solution {
    public String frequencySort(String s) {
        int[] arr = new int[123];
        int maxCount = 0;
        for (char c : s.toCharArray()){
            arr[c] += 1;
            maxCount = Math.max(arr[c], maxCount);
        }
        List<Character>[] countArr = new List[maxCount];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                if(countArr[arr[i] - 1] == null){
                    countArr[arr[i] - 1] = new ArrayList();
                }
                countArr[arr[i] - 1].add((char) i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = countArr.length - 1; i >= 0; i--) {
            if (countArr[i] == null){
                continue;
            }
            for(char c : countArr[i]){
                for (int j = 0; j <= i; j++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
    }
}
