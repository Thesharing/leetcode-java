public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[m + n];
        int i = 0; 
        int j = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                ans[i + j] = nums1[i++];
            }
            else{
                ans[i + j] = nums2[j++];
            }
        }
        if(i < m){
            for(int k = i; k < m; k++){
                ans[k + j] = nums1[k];
            }
        }
        if(j < n){
            for(int k = j; k < n; k++){
                ans[i + k] = nums2[k];
            }
        }
        for(int k = 0; k < m + n; k++){
            nums1[k] = ans[k];
        }
    }
}