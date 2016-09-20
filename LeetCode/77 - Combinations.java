/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < k){
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        func(res, temp, 1, k, n);
        return res;
    }
    
    public void func(List<List<Integer>> res, List<Integer> temp, int pos, int k, int n){
        if(k == 0){
            res.add(new ArrayList<Integer>(temp));
        }
        else{
            for(int i = pos; i <= n - k + 1; i++){
                temp.add(i);
                func(res, temp, i + 1, k - 1, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
}