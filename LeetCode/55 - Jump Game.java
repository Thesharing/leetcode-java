/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/

public class Solution {
    public boolean canJump(int[] nums) {
        boolean res = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                res = checkZero(nums, i);
                if(res == false){
                    break;
                }
            }
        }
        return res;
    }
    public boolean checkZero(int []nums, int pos){
        boolean res = false;
        for(int i = 1; i <= pos; i++){
            if(nums[pos - i] + pos - i > pos){
                res = true;
                break;
            }
        }
        return res;
    }
}