package com.nacht.sn_0050;

/**
 * @author Nacht
 * Created on 2024/9/10 12:23
 */
public class Solution {
    public double myPow(double x, int n) {
        long k = n;
        return k > 0 ? pow(x, k) : 1.0 / pow(x, -k);
    }
    public double pow(double x, long n){
        if (n == 0){
            return 1;
        }
        double result = pow(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, 10));
    }
}
