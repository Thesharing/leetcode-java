/*

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        if(n == 0){
            return res;
        }
        int k = 1;
        int i = 0;
        int j = 0;
        res[0][0] = 1;
        while(k < n * n){
            while(j + 1 < n && res[i][j + 1] == 0){
                res[i][++j] = ++k;
            }
            while(i + 1 < n && res[i + 1][j] == 0){
                res[++i][j] = ++k;
            }
            while(j > 0 && res[i][j - 1] == 0){
                res[i][--j] = ++k;
            }
            while(i > 0 && res[i - 1][j] == 0){
                res[--i][j] = ++k;
            }
        }
        return res;
    }
}