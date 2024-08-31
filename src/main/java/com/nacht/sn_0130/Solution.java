package com.nacht.sn_0130;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/8/27 23:41
 */
public class Solution {
    public void solve(char[][] board) {
        boolean[][] fuckOArea = new boolean[board.length][board[0].length];
        for (int i = 0; i <= board.length - 1; i++) {
            dfs(board, i, 0, fuckOArea);
            dfs(board, i, board[0].length - 1, fuckOArea);
        }
        for (int j = 1; j < board[0].length - 1; j++){
            dfs(board, 0, j, fuckOArea);
            dfs(board, board.length - 1, j, fuckOArea);
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] != 'X' && !fuckOArea[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] fuckOArea) {
        /*越界不处理*/
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1){
            return;
        }
        if (board[i][j] != 'X' && !fuckOArea[i][j]){
            fuckOArea[i][j] = true;
            dfs(board, i, j - 1, fuckOArea);
            dfs(board, i - 1, j, fuckOArea);
            dfs(board, i + 1, j, fuckOArea);
            dfs(board, i, j + 1, fuckOArea);
        }

    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'X'}
        };
        new Solution().solve(board);
    }
}
