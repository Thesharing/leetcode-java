/*

Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

*/

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++){
            run(res, n, i);
        }
        return res;
    }
    
    public void run(List<Integer> res, int n, int num){
        if(num <= n){
            res.add(num);
            for(int i = 0; i< 10; i++){
                run(res, n, num * 10 + i);
            }
        }
    }
}