/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

*/

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        add(candidates, target, res, 0, temp);
        return res;
    }
    
    public static void add(int[] candidates, int target, List<List<Integer>> res, int pos, List<Integer> temp){
        for(int i = pos; i < candidates.length; i++){
          if(target > candidates[i]){
            temp.add(new Integer(candidates[i]));
            add(candidates, target - candidates[i], res, i, temp);
            temp.remove(new Integer(candidates[i]));
          }
          else if(target == candidates[i]){
            temp.add(new Integer(candidates[i]));
            res.add(new ArrayList<Integer>(temp));
            temp.remove(new Integer(candidates[i]));
          }
          else{
            break;
          }
        }
    }
}