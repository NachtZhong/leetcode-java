package com.nacht.sn_0009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/8/31 15:09
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0){
            return true;
        }
        /*负数, 或者以0结尾的正数必定不是回文数*/
        if (x < 0 || x % 10 == 0){
            return false;
        }
        int origin = x;
        int t = 0;
        while (x > 0){
            int remainder = x % 10;
            t = t * 10 + remainder;
            x /= 10;
        }
        return t == origin;
    }
}
