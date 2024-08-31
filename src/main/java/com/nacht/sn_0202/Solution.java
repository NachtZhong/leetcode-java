package com.nacht.sn_0202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/8/31 08:53
 */
public class Solution {
    public boolean isHappy(int n) {
        int fast = calcNext(n), slow = n;
        while (fast != 1 && fast != slow){
            slow = calcNext(slow);
            fast = calcNext(calcNext(fast));
        }
        return fast == 1;
    }
    public int calcNext(int n){
        int result = 0;
        int current = 10;
        while (n > 0){
            int digit = n % current;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }
}
