/*

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?


*/

public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = 0;
        int pos = 0;
        while(pos < nums.length - two){
            if(nums[pos] == 0){
                nums[zero++] = 0;
                pos++;
            }
            else if(nums[pos] == 1){
                pos++;
            }
            else if(nums[pos] == 2){
                swap(nums, pos, nums.length - two - 1);
                nums[nums.length - two - 1] = 2;
                two++;
            }
        }
        for(int i = pos - 1; i >= zero; i--){
            nums[i] = 1;
        }
    }
  
  public void swap(int[] nums, int a, int b){
    int temp = nums[b];
    nums[b] = nums[a];
    nums[a] = temp;
  }
}