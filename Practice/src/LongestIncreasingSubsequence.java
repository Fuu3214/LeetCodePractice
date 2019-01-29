
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > dp[end]) {
            	dp[++end] = nums[i];
            }
            else {
            	int pos = find(dp, end, nums[i]);
            	dp[pos] = nums[i];
            }
        }
		return end+1;
    }
    
    public int find(int[] arr, int right, int tar) {
    	int left = 0;
    	while(left < right) {
    		int mid = left + (right - left)/2;
    		if(arr[mid] > tar) {
    			right = mid;
    		}
    		else if(arr[mid] < tar) {
    			left = mid+1;
    		}
    		else
    			return mid;
    	}
    	return left;
    }
}
