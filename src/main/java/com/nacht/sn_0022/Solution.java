package com.nacht.sn_0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nacht
 * Created on 2024/9/14 03:21
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, result, new char[2 * n]);
        return result;
    }

    /**
     * dfs+回溯
     * @param n 总共可用的左括号数量
     * @param lCount 当前已经使用的左括号数量
     * @param rCount 当前已经使用的右括号数量
     * @param result 结果集
     * @param characters 当前已经拼接的括号
     */
    private void dfs(int n, int lCount, int rCount, List<String> result, char[] characters) {
        /*已经走到最后一个左括号了, 补上还差的右括号, 加到结果集里面*/
        if (lCount + rCount == 2 * n){
            result.add(new String(characters));
            return;
        }
        /*左右括号当前数量相等, 下一个只能插入左括号*/
        if (lCount == rCount){
            characters[lCount + rCount] = '(';
            dfs(n, lCount + 1, rCount, result, characters);
        }
        /*左括号数量满了, 下一个只能插入右括号*/
        else if (lCount == n) {
            characters[lCount + rCount] = ')';
            dfs(n, lCount, rCount + 1, result, characters);
        }
        /*左右括号都能插, 分别DFS回溯*/
        else{
            characters[lCount + rCount] = '(';
            dfs(n, lCount + 1, rCount, result, characters);
            characters[lCount + rCount] = ')';
            dfs(n, lCount, rCount + 1, result, characters);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
