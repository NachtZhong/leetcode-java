```azure
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

 

示例 1：

输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
示例 2：

输入：c = 3
输出：false
 

提示：

0 <= c <= 231 - 1
```
## 解题思路
左指针0, 右指针大于c开方的第一个整数, 多退少补中间逼近。