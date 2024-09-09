package com.nacht.sn_0017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/5 18:26
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        char[] arr = digits.toCharArray();
        dfs(arr, result, new StringBuilder(), 0);
        return result;
    }

    private void dfs(char[] arr, List<String> result, StringBuilder sb, int current) {
        if (current >= arr.length) {
            result.add(sb.toString());
            return;
        }
        if (arr[current] == '1') {
            dfs(arr, result, sb, current + 1);
        }
        for (char c : getCharsByDigit(arr[current])) {
            sb.append(c);
            dfs(arr, result, sb, current + 1);
            sb.setLength(sb.length() - 1);
        }
    }


    public char[] getCharsByDigit(char dight) {
        switch (dight) {
            case '1':
                return new char[]{};
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }
}
