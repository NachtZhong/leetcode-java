package com.nacht.sn_0064;

/**
 * @author Nacht
 * Created on 2024/9/13 21:09
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        /*这样写足够优雅了, 无奈ac比较慢*/
        /*要提速, 可以把grid和grid[0]的length提前拿出来, 后面直接用变量, 并且先处理两个边, 减少循环里面的条件判断, 当然这里没必要那样写了*/
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        new Solution().minPathSum(new int[][]{
                {1,3,1}, {1,5,1}, {4,2,1}
        });
    }
}
