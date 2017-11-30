/*
532. K-diff Pairs in an Array

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
*/

public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
	int pairs=0;
	int [] sum =new int [nums.length];
	for (int i = 1; i < nums.length; i++) 
		sum[i] = nums[i] - nums[i-1];
	
	
	if (k==0) {
		for (int i = 1; i < nums.length-1; i++) {
			if(i==nums.length-2 && sum[i+1]==0)
				++pairs;
			if(sum[i]==sum[i+1]) 
				continue;
			
				
			if (sum[i]==0) 
				++pairs;
			
		}
		if(nums.length==2 && sum[1]==0) pairs=1;
		
	}else {
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==nums[i+1]) 
				continue;
				
			for (int j = i+1; j < nums.length; j++) 
				if (Math.abs(nums[i] - nums[j]) == k) {
					++pairs;
					break;
				}
			
		}
	}
	
	
	return pairs;
}
//k==0时的不同解法
class Solution {
    public int findPairs(int[] nums, int k) {
    	Arrays.sort(nums);
		int pairs=0;
		
		if(nums.length <2)
            return 0;
		if (k==0) {
	        int i=0,count=0,sta = nums[0];
	        if(nums[1]==nums[0])
	        	count = 1;
			while(i < nums.length-1){
	            if(nums[i] == nums[i+1] && nums[i] != sta){
                    sta=nums[i];
	                count++;
	                i++;
	            }
	            i++;
	        }
			
	        pairs = count;
		}else {
			for (int i = 0; i < nums.length-1; i++) {
				if(nums[i]==nums[i+1]) 
					continue;
					
				for (int j = i+1; j < nums.length; j++) 
					if (Math.abs(nums[i] - nums[j]) == k) {
						++pairs;
						break;
					}
				
			}
		}
		
		
		return pairs;
}
}