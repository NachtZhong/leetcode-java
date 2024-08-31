package com.nacht.sn_0079;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Nacht
 * Created on 2024/8/27 21:13
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        /*做一些提前的判断*/
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        Map<Character, Integer> boardFreq = new HashMap<>();
        Map<Character, Integer> wordFreq = new HashMap<>();

        for (char[] row : board) {
            for (char c : row) {
                boardFreq.put(c, boardFreq.getOrDefault(c, 0) + 1);
            }
        }

        for (char c : word.toCharArray()) {
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
            if (wordFreq.get(c) > boardFreq.getOrDefault(c, 0)) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = dfs(board, word, i, j, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        /*走完了, 返回true*/
        if (idx == word.length()) {
            return true;
        }
        /*越界判断*/
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        /*当前字符不等, 返回false*/
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        /*当前位置已经走过了, 返回false*/
        if (board[i][j] == '#') {
            return false;
        }
        /*字符匹配上了, 从没走过的节点继续dfs判断剩余字符*/
        char tmp = board[i][j];
        board[i][j] = '#';
        if (dfs(board, word, i - 1, j, idx + 1)) return true;
        if (dfs(board, word, i + 1, j, idx + 1)) return true;
        if (dfs(board, word, i, j - 1, idx + 1)) return true;
        if (dfs(board, word, i, j + 1, idx + 1)) return true;
        board[i][j] = tmp;
        return false;
    }
}
