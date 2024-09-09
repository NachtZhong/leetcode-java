package com.nacht.sn_0071;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2024/9/9 15:51
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr){
            /*空白的字符串, 不做处理*/
            if (s.isEmpty()) continue;
            /*当前路径, 不做处理*/
            if (s.equals(".")) continue;
            /*上一个目录, 把前面的给pop出来*/
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        StringBuilder result = new StringBuilder();
        for (String s : stack){
            result.append("/");
            result.append(s);
        }
        String res = result.toString();
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home//foo/"));
    }
}
