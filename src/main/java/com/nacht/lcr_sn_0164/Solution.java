package com.nacht.lcr_sn_0164;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nacht
 * Created on 2024/8/13 04:21
 */
public class Solution {
    public String crackPassword(int[] password) {
        Integer[] passwords = Arrays.stream(password).boxed().toArray(Integer[]::new);
        Arrays.sort(passwords, (a, b) -> {
            long ab = Long.parseLong(a + String.valueOf(b));
            long ba = Long.parseLong(b + String.valueOf(a));;
            return Long.compare(ab, ba);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passwords.length; i++) {
            sb.append(passwords[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().crackPassword(new int[]{999999998,999999997,999999999}));
    }
}
