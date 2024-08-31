package com.nacht.sn_0383;

/**
 * @author Nacht
 * Created on 2024/8/31 04:15
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countArr = new int[26];
        for (char c : magazine.toCharArray()){
            countArr[c - 'a'] += 1;
        }
        for(char c : ransomNote.toCharArray()){
            countArr[c - 'a'] -= 1;
            if (countArr[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
