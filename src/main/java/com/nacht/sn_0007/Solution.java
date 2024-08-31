package com.nacht.sn_0007;

class Solution {
    public int reverse(int x) {
        String MAX_INT_STR = "2147483647";
        String MIN_INT_STR = "2147483648";
        String xStr = String.valueOf(x);
        /*是否为正数*/
        boolean isPositive = x >= 0;
        /*用于判断是否溢出基准*/
        String outOfRangeBenchMark = isPositive ? MAX_INT_STR: MIN_INT_STR;
        int result = 0;
        /*明确溢出直接返回*/
        if ((isPositive && xStr.length() > 10) || (!isPositive && xStr.length() > 11)){
            return result;
        }
        boolean dangerous = (isPositive && xStr.length() == 10) || (!isPositive && xStr.length() == 11);
        int plusNumber = getPlusNumber(xStr, isPositive);
        int endIndex = isPositive ? 0:1;
        for(int i = xStr.length() - 1; i >= endIndex; i--){
            char current = xStr.charAt(i);
            if (dangerous && current > outOfRangeBenchMark.charAt(xStr.length() - 1 - i)){
                return 0;
            }else {
                if(current < outOfRangeBenchMark.charAt(xStr.length() - 1 - i)){
                    dangerous = false;
                }
                result += (current - 48) * plusNumber;
                plusNumber /= 10;
            }
        }
        return isPositive ? result : -result;
    }

    /**
     * 获取基础乘数权重
     */
    public int getPlusNumber(String xStr, boolean isPositive){
        int result = 1;
        int plusCount = xStr.length() - 1;
        if(!isPositive){
            plusCount --;
        }
        while (plusCount > 0){
            result *= 10;
            plusCount--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-1223125611));
    }
}