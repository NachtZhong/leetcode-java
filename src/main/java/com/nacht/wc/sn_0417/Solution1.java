package com.nacht.wc.sn_0417;

/**
 * @author Nacht
 * Created on 2024/9/29 23:59
 */
public class Solution1 {
    public char kthCharacter(int k) {
        if (k == 1){
            return 'a';
        }
        int tmp = 1;
        while(tmp < k){
            tmp *= 2;
        }
        tmp /= 2;
        return (char) (kthCharacter(k - tmp) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().kthCharacter(5));
    }
}
