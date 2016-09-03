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