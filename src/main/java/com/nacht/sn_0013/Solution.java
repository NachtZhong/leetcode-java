package com.nacht.sn_0013;

/**
 * @author Nacht
 * Created on 2024/8/30 20:28
 */
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        int currentValue = 0;
        for (int i = 0; i < s.length(); i++) {
            currentValue = getValue(s.charAt(i));
            result += prevValue >= currentValue ? prevValue : -prevValue;
            prevValue = currentValue;
        }
        return result + currentValue;
    }
    private int getValue(char c){
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
