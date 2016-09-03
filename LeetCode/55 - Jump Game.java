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