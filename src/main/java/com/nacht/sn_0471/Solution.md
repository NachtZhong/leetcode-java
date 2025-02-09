```azure
题目描述
给定一个二维的非负整数矩阵，每个位置的值表示海拔高度。假设左边和上边是太平洋，右
边和下边是大西洋，求从哪些位置向下流水，可以流到太平洋和大西洋。水只能从海拔高的位置
流到海拔低或相同的位置。
输入输出样例
输入是一个二维的非负整数数组，表示海拔高度。输出是一个二维的数组，其中第二个维度
大小固定为 2，表示满足条件的位置坐标。
Input:
太平洋 ~ ~ ~ ~ ~
      ~ 1 2 2 3 (5) *
      ~ 3 2 3 (4) (4) *
      ~ 2 4 (5) 3 1 *
      ~ (6) (7) 1 4 5 *
      ~ (5) 1 1 2 4 *
      * * * * * 大西洋
Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
在这个样例中，有括号的区域为满足条件的位置。
```
## 解题思路
其实就是看哪些位置能走到两个海洋, 如果我们遍历所有的矩形, 那么会有很多无用的遍历, 不妨逆向思考一下, 不从矩形出发, 而是反向从海洋边界往里面做DFS

同样的, 走过的节点我们不需要再继续走, 因为是DFS, 能经过这个节点走到海洋的节点肯定会在第一次DFS的时候遍历到。