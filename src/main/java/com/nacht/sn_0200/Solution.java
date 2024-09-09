package com.nacht.sn_0200;

/**
 * @author Nacht
 * Created on 2024/9/9 15:02
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*非陆地, 或者已经走过的陆地, 不处理*/
                if (grid[i][j] == '0') continue;
                dfs(grid, i, j, m, n);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        /*超出边界了, 或者走到水了, 或者曾经走过了, 返回*/
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        /*前后左右走一走*/
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i, j + 1, m, n);
    }
}
