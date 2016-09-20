/*

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp;
        if(len == 1){
            return;
        }
        int limit;
        for(int i = 0; i < (len + 1)/2; i++){
            if(len % 2 == 0){
                limit = (len + 1)/2;
            }
            else{
                limit = (len - 1)/2;
            }
            for(int j = 0; j < limit; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 -j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}