/*

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int times = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[count++] = nums[i];
                times = 1;
            }
            else if(nums[i] == nums[i - 1] && times > 0){
                nums[count++] = nums[i];
                times = 0;
            }
        }
        return count;
    }
}