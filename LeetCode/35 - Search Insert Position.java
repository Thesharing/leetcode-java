/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class Solution {
    public static int end = 0;
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        end = nums.length - 1;
        int res = binarySearch(nums, 0, end, target);
        if(res < 0){
            if(nums[end] < target)
                return end+1;
            else
                return end;
        }
        return res;
    }
    public static int binarySearch(int[] nums, int a, int b, int target){
        end = b;
        if(a > b || (a == b && nums[a] != target)){
            return -1;
        }
        int mid = (a+b)/2;
        if(nums[mid] == target){
            return (a+b)/2;
        }
        else{
            if(nums[mid] > target){
                return binarySearch(nums, a, mid, target);
            }
            else{
                return binarySearch(nums, mid + 1, b, target);
            }
        }
    }
}