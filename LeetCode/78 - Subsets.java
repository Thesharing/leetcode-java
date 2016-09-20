/*

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>(temp));
        addRes(res, nums, 0, temp);
        return res;
    }
    
    public void addRes(List<List<Integer>> res, int[] nums, int pos, List<Integer> temp){
        for(int i = pos; i < nums.length; i++){
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            addRes(res, nums, i + 1, temp);
            temp.remove(new Integer(nums[i]));
        }
    }
}
