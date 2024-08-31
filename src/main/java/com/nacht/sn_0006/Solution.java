package com.nacht.sn_0006;

/**
 * @author Nacht
 * Created on 2024/8/31 00:23
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        /*3行的时候, 横向一个z去下面的横线能放3 + 1个元素, 占2列*/
        /*4行的时候, 横向一个z去下面的横线能放4 + 2个元素, 占3列*/
        /*5行的时候, 横向一个z去下面的横线能放5 + 3个元素, 占4列*/
        int m = numRows, n = (s.length() / (2 * (numRows - 1)) + 1) * (numRows - 1);
        char[][] arr = new char[m][n];
        int i = 0, j = 0, current = 0;
        while (current < s.length()){
            /*首先放第一列*/
            while (i < m && current < s.length()){
                arr[i][j] = s.charAt(current);
                i++;
                current++;
            }
            if (current == s.length()){
                break;
            }
            /*然后放那个sb的中间连接*/
            i-=2;
            j+=1;
            while (i > 0 && current < s.length()){
                arr[i][j] = s.charAt(current);
                i--;
                j++;
                current++;
            }
        }
        StringBuilder result = new StringBuilder();
        i = 0;
        while (i < arr.length){
            j = 0;
            while (j < arr[0].length){
                if (arr[i][j] != '\0'){
                    result.append(arr[i][j]);
                }
                j++;
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("ABCDE", 4));
    }
}
