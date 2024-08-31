package com.nacht.sn_0392;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/8/31 03:41
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c1.length > c2.length){
            return false;
        }
        int l = 0, r = 0;
        while (l < c1.length && r < c2.length){
            if (c1[l] == c2[r++]){
                l++;
            }
        }
        return l == c1.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));
    }
}
