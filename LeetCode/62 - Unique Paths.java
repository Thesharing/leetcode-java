/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.

*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m >= n){
            return (int)(fractor(m - 1, m + n - 2, n - 1));
        }
        if(m < n){
            return (int)(fractor(n - 1, m + n - 2, m - 1));
        }
        return 0;
    }
    
    public double fractor(int m, int n, int k){
        double res = 1;
        while(n > m){
            res *= ++m;
        }
        while(k > 0){
            res /= k--;
        }
        return res;
    }
}