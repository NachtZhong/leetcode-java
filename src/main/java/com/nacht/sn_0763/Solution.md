```java
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

返回一个表示每个字符串片段的长度的列表。

 

示例 1：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
示例 2：

输入：s = "eccbbbbdec"
输出：[10]
 

提示：

1 <= s.length <= 500
s 仅由小写英文字母组成
```

贪心算法
首先, 我们遍历一遍数组, 记录下每个字母的最左和最右索引;
然后从左到右遍历数组, 找到第一个最短的分段, 定位规则如下:
首先将该段的区间定为第一个字母的最左和最右索引, 然后在区间内遍历, 如果区间内其他字母的最右索引超出当前区间右边界, 调整右边界为该字母的右边界, 如果没有继续查找下一个元素;
直到指针到达右边界, 此时区间内所有字母都在当前段内, 划分为一个段, 继续划分下一个段直至完成;
