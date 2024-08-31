package com.nacht.sn_0695;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Nacht
 * Created on 2024/8/27 01:19
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*max area*/
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                maxArea = Math.max(maxArea, dfsSearch(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfsSearch(int[][] grid, int i, int j) {
        /*越界不走, 海洋不走*/
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 +
                dfsSearch(grid, i + 1, j) +
                dfsSearch(grid, i - 1, j) +
                dfsSearch(grid, i, j - 1) +
                dfsSearch(grid, i, j + 1);
    }

    public static void main(String[] args) {
    }
}