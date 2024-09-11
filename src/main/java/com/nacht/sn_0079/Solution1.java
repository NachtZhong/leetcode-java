package com.nacht.sn_0079;

/**
 * @author Nacht
 * Created on 2024/9/11 18:11
 */
public class Solution1 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        /*首先, 我们做一下剪枝, 提前排除掉不可能的情况。*/
        char[] wordArr = word.toCharArray();
        /*如果字符数量都不够word长, 那肯定不行的*/
        if (wordArr.length > m * n){
            return false;
        }
        /*看看每个字符的数量是否能满足要求, 如果不能, 也是不行的*/
        int[] boardCharCountArr = new int[52];
        int[] wordCharCountArr = new int[52];
        for (char[] arr : board){
            for (char c : arr){
                int idx = c <= 'Z' ? c - 'A' : c - 'a' + 26;
                boardCharCountArr[idx] ++;
            }
        }
        for (char c : wordArr){
            int idx = c <= 'Z' ? c - 'A' : c - 'a' + 26;
            wordCharCountArr[idx] ++;
            if (wordCharCountArr[idx] > boardCharCountArr[idx]){
                return false;
            }
        }
        /*前置校验过了, 我们开始dfs找是否有满足的*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, wordArr, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] wordArr, int i, int j, int current) {
        /*走到了结尾, 证明匹配成功了*/
        if (current == wordArr.length){
            return true;
        }
        /*越界了, 返回false*/
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        /*当前字符不匹配, 或者前面已经走过了, 返回false*/
        if (board[i][j] != wordArr[current] || board[i][j] == '#'){
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        /*继续走, 看剩下的是否匹配*/
        if (dfs(board, wordArr, i - 1, j, current + 1)) return true;
        if (dfs(board, wordArr, i + 1, j, current + 1)) return true;
        if (dfs(board, wordArr, i, j - 1, current + 1)) return true;
        if (dfs(board, wordArr, i, j + 1, current + 1)) return true;
        /*回溯*/
        board[i][j] = tmp;
        return false;
    }

    public static void main(String[] args) {
        new Solution1().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "SEE");
    }
}
