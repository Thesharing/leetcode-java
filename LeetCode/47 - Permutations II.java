/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> numsInt = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
            numsInt.add(nums[i]);
        }
        Collections.sort(numsInt);
        int visited[] = new int [nums.length];
        calc(res, temp, numsInt, visited);
        return res;
    }
    
    public void calc(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, int visited[]){
        if(nums.size() == temp.size()){
            res.add(new ArrayList<Integer>(temp));
        }
        else{
            for(int i = 0; i < nums.size(); i++){
                if(visited[i] == 1 || (i > 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)){
                    continue;
                }
                else{
                    temp.add(nums.get(i));
                    visited[i] = 1;
                    calc(res, temp, nums, visited);
                    temp.remove(temp.size() - 1);
                    visited[i] = 0;
                }
            }
        }
    }
}