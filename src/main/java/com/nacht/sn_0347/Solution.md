```azure
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 

进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
```
## 解题思路
首先, 我们用一个几把map, 统计出各个数字出现的个数, 同时记录最大重复的个数, 不妨记为max
然后我们定义一个长度为max的数组, 数组里面位置i存储的是出现频次为i+1的数字列表, 倒序遍历数组, 返回k个就行了