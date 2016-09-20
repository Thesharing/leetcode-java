/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        if(matrix[0][0] > target){
            return false;
        }
        while(i < m - 1){
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                break;
            }
            else{
                i++;
            }
        }
        if(matrix[i][0] == target){
            return true;
        }
        for(int j = 1; j < n; j++){
            if(matrix[i][j] >= target){
                if(matrix[i][j - 1] == target || matrix[i][j] == target){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}