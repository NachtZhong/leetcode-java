package com.nacht.sn_0150;

/**
 * @author Nacht
 * Created on 2024/9/9 22:16
 */
public class Solution1 {
    public int evalRPN(String[] tokens) {
        /*不妨就试试, 按题目说的, 碰到数字就入栈, 碰到运算符就弹出顶上两个数字进行运算*/
        /*用栈虽然ac了, 性能不是很理想, 直接用数组做一个简单的stack*/
        int[] arr = new int[tokens.length];
        int stackIdx = -1;
        for (String token : tokens){
            switch (token){
                case "+":{
                    arr[stackIdx - 1] = arr[stackIdx - 1] + arr[stackIdx--]; continue;
                }
                case "-":{
                    arr[stackIdx - 1] = arr[stackIdx - 1] - arr[stackIdx--]; continue;
                }
                case "*":{
                    arr[stackIdx - 1] = arr[stackIdx - 1] * arr[stackIdx--]; continue;
                }
                case "/":{
                    arr[stackIdx - 1] = arr[stackIdx - 1] / arr[stackIdx--]; continue;
                }
                default:{
                    arr[++stackIdx] = Integer.parseInt(token);
                }
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
