/*
560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find 
the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
*/
public int subarraySum(int[] nums, int k) {
    int count=0,sum=0;
	for (int i = 0; i < nums.length; i++) {
		sum=nums[i];
		if(sum==k)
    		count++;
		for (int j = i+1; j < nums.length; j++) {
			sum+=nums[j];
			if (sum==k) {
				count++;
				continue;
			}
		}
	}
	return count;
}