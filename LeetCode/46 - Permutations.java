/*

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        calc(res, temp, nums);
        return res;
    }
    
    public void calc(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
        }
        else
            for(int i = 0; i < nums.length; i++){
                if(!temp.contains(new Integer(nums[i]))){
                    temp.add(new Integer(nums[i]));
                    calc(res, temp, nums);
                    temp.remove(new Integer(nums[i]));
                }
            }
    }
}