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
        long l = 0, r = x, mid;
        while(l <= r){
            mid = (l + r) / 2;
            if (mid == l || mid == r){
                return (int) mid;
            }
            long current = mid * mid;
            if (current == x){
                return (int) mid;
            } else if (current < x) {
                l = mid;
            }else{
                r = mid;
            }
        }
        return (int) l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}
