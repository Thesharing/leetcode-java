/*

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int res[] = new int[2];
        for(int i = 0; i < len; i++){
            int p = Arrays.binarySearch(numbers, i + 1, len, target - numbers[i]);
            if(p >= 0){
                res[0] = i + 1;
                res[1] = p + 1;
                return res;
            }
        }
        return res;
    }
    
}
