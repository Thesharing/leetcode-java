/*

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int [2];
        int len = nums.length - 1;
        res[0] = -1;
        res[1] = -1;
        int mid = binarySearch(nums, 0, len, target);
        if(mid > -1){
            res [0] = mid;
            res [1] = mid;
            int c = 0;
            while(res[0] > 0){
                c = binarySearch(nums, 0, res[0] - 1, target);
                if(c != -1){
                    res[0] = c;
                }
                else
                    break;
            }
            while(res[1] < nums.length - 1){
                c = binarySearch(nums, res[1] + 1, len, target);
                if(c != -1){
                    res[1] = c;
                }
                else
                    break;
            }
        }
        return res;
    }
    
    public int binarySearch(int[] nums, int a, int b, int target){
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