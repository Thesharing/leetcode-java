/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] isChecked = new int[m][n];
        int k = 0;
        int i = 0; 
        int j = 0;
        while(k < m * n  - 1){
            while(j + 1 < n && isChecked[i][j + 1] != 1){
                isChecked[i][j] = 1;
                res.add(matrix[i][j++]);
                k++;
            }
            while(i + 1 < m && isChecked[i + 1][j] != 1){
                isChecked[i][j] = 1;
                res.add(matrix[i++][j]);
                k++;
            }
            while(j > 0 && isChecked[i][j - 1] != 1){
                isChecked[i][j] = 1;
                res.add(matrix[i][j--]);
                k++;
            }
            while(i > 0 && isChecked[i - 1][j] != 1){
                isChecked[i][j] = 1;
                res.add(matrix[i--][j]);
                k++;
            }
        }
        if(k < m * n)
            res.add(matrix[i][j]);
        return res;
    }
}