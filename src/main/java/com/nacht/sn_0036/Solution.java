package com.nacht.sn_0036;

/**
 * @author Nacht
 * Created on 2024/9/9 23:25
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*用来统计每行每个数字的数量*/
        int[][] rows = new int[9][9];
        /*用来统计每列每个数字的数量*/
        int[][] columns = new int[9][9];
        /*用来统计每个方格每个数字的数量*/
        int[][][] cells = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current == '.') continue;
                int currentNum = current - '1';
                rows[i][currentNum] += 1;
                if (rows[i][currentNum] > 1) return false;
                columns[j][currentNum] += 1;
                if (columns[j][currentNum] > 1) return false;
                cells[i/3][j/3][currentNum] += 1;
                if (cells[i/3][j/3][currentNum] > 1) return false;
            }
        }
        return true;
    }
}
