/*
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        //查找target记录位置
	    int status=Arrays.binarySearch(nums, target);
	        
	    //如果target不在数组内，则插入到
	    if(status<0) {
	        for (int i = 0; i < nums.length; i++){
				if (target<nums[i]) {
					status=i;
					break;
				}
			}
	        	
	        if(target > nums[nums.length-1])status=nums.length;
	    }
	        
	    return status;
    }
}