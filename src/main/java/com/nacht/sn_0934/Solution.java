package com.nacht.sn_0934;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2024/8/27 22:08
 */
public class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>(10000);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                /*匹配到第一个岛, 先dfs进行查找标记, 再通过bfs找和另外一个岛的最短距离*/
                if (grid[i][j] == 1){
                    dfs(grid, i, j, queue);
                    return bfs(grid, queue, 0);
                }
            }
        }
        return -1;
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int level) {
        int queueSize = queue.size();
        while (queueSize-- > 0){
            int[] idx = queue.poll();
            int i = idx[0];
            int j = idx[1];
            if(isOutOfBorder(grid, i, j)){
                continue;
            }
            if (grid[i][j] == 0){
                grid[i][j] = 2;
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i, j - 1});
                queue.offer(new int[]{i, j + 1});
            }else if (grid[i][j] == 1){
                return level;
            }
        }
        return bfs(grid, queue, level + 1);
    }

    private boolean isOutOfBorder(int[][] grid, int i, int j){
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        /*越界判断*/
        if (isOutOfBorder(grid, i, j)){
            return;
        }
        /*走到了海洋或者自己, 直接返回*/
        if (grid[i][j] == 0 || grid[i][j] == 2){
            return;
        }
        grid[i][j] = 2;
        queue.offer(new int[]{i - 1, j});
        queue.offer(new int[]{i + 1, j});
        queue.offer(new int[]{i, j - 1});
        queue.offer(new int[]{i, j + 1});
        /*没事走两步*/
        dfs(grid, i+1, j, queue);
        dfs(grid, i-1, j, queue);
        dfs(grid, i, j+1, queue);
        dfs(grid, i, j-1, queue);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0, 1},
                {1, 0}
        }));
    }
}
