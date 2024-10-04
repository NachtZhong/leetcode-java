package com.nacht.sn_0471;

import java.util.*;

/**
 * @author Nacht
 * Created on 2024/8/27 14:07
 */
public class Solution {
    enum SourceType{
        P, A, BOTH, NONE;
    }
    enum FromType{
        TOP, BOTTOM, LEFT, RIGHT, ROOT
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        /*用来记录某个标志位能否走到太平洋*/
        int[][] resultArrP = new int[m][n];
        /*用来记录某个标志位能否走到大西洋*/
        int[][] resultArrA = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                SourceType sourceType = getSourceType(heights, i, j);
                if (sourceType == SourceType.NONE){
                    continue;
                }
                dfs(heights, i, j, resultArrA, resultArrP, sourceType, -1, FromType.ROOT);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (resultArrA[i][j] == 1 && resultArrP[i][j] == 1){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, int[][] resultArrA, int[][] resultArrP, SourceType sourceType, int preValue, FromType fromType) {
        /*越界不处理*/
        if (i < 0 || i > heights.length - 1 || j < 0 || j > heights[0].length - 1){
            return;
        }
        /*走过了的不处理*/
        if ((sourceType == SourceType.P && resultArrP[i][j] == 1) || (sourceType == SourceType.A && resultArrA[i][j] == 1) || (sourceType == SourceType.BOTH && resultArrA[i][j] == 1)){
            return;
        }
        if (heights[i][j] >= preValue){
            switch (sourceType){
                case P: resultArrP[i][j] = 1;   break;
                case A: resultArrA[i][j] = 1;   break;
                case BOTH: resultArrP[i][j] = 1; resultArrA[i][j] = 1;  break;
            }
            if (fromType != FromType.LEFT) dfs(heights, i - 1, j, resultArrA, resultArrP, sourceType, heights[i][j], FromType.RIGHT);
            if (fromType != FromType.TOP) dfs(heights, i, j - 1, resultArrA, resultArrP, sourceType, heights[i][j], FromType.BOTTOM);
            if (fromType != FromType.BOTTOM) dfs(heights, i, j + 1, resultArrA, resultArrP, sourceType, heights[i][j], FromType.TOP);
            if (fromType != FromType.RIGHT) dfs(heights, i + 1, j, resultArrA, resultArrP, sourceType, heights[i][j], FromType.LEFT);
        }

    }


    private SourceType getSourceType(int[][] heights, int i, int j){
        if ((i == 0 && (j == heights[0].length - 1 || heights.length == 1)) || ((i == heights.length - 1 || heights[0].length == 1) && j == 0)){
            return SourceType.BOTH;
        }
        if (i == 0 || j == 0){
            return SourceType.P;
        }
        if (i == heights.length - 1 || j == heights[0].length - 1){
            return SourceType.A;
        }
        return SourceType.NONE;
    }

    public static void main(String[] args) {
        //[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//        System.out.println(new Solution.sql.md.md.md.md().pacificAtlantic(new int[][]{
//                {1, 2, 2, 3, 5},
//                {3, 2, 3, 4, 4},
//                {2, 4, 5, 3, 1},
//                {6, 7, 1, 4, 5},
//                {5, 1, 1, 2, 4},
//        }));
        int[][] array = {
                {13}, {4}, {19}, {10}, {1}, {11}, {5}, {17}, {3}, {10}, {1}, {0}, {1}, {4}, {1}, {3}, {6}, {13}, {2}, {16},
                {7}, {6}, {3}, {1}, {9}, {9}, {13}, {10}, {9}, {10}, {6}, {2}, {11}, {17}, {13}, {0}, {19}, {7}, {13}, {3}, {9}, {2}
        };
        System.out.println(new Solution().pacificAtlantic(array));
    }
}
