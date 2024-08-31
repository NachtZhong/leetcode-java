package com.nacht.sn_0069;

/**
 * @author Nacht
 * Created on 2024/8/26 10:54
 */
public class Solution {
    public int mySqrt(int x) {
        return calcSqrt2(x);
    }
    public int calcSqrt1(int x){
        /*牛顿迭代法*/
        long a = x;
        while(a * a > x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
    public int calcSqrt2(int x){
        if (x == 1){
            return x;
        }
        /*二分法*/
        long l = 0, r = x, mid = (l + r) / 2, current;
        while((current = mid * mid) != x){
            /*mid碰到边界了就返回*/
            if (mid == l || mid == r){
                return (int) mid;
            }
            if (current > x){
                /*结果在左*/
                r = mid;
            }else{
                /*结果在右*/
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return (int) mid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}
