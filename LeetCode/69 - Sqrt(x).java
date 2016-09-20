/*

Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {
    public int mySqrt(int x) {
        return func(0, x, x);
    }
    
    public int func(long a, long b, long x){
        if(a > b)
            return (int)b;
        long z = a + (b - a) / 2;
        if(z * z < x){
            return func(z + 1, b, x);
        }
        else if(z * z > x){
            return func(a, z - 1, x);
        }
        return (int)z;
    }
}