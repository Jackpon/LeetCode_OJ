/*
724. Find Pivot Index

Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:
Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
#题意：
	大概就是说找到一个索引使得数组两边和相等
*/

//我原先思路是打算用类似于二分查找方式比较得出，但结果是错的，因为不能概括所有数组值
public static int pivotIndex(int[] nums) {
    int sum1=nums[0],sum2=nums[nums.length-1];
    int i=1,j=nums.length-2;
    while(i<=j) {
    	if(sum1==sum2)
    		break;
    	if(sum1<sum2)
    		sum1+=nums[i++];
    	if(sum1>sum2)
    		sum2+=nums[j--];
    }
    if(i<=j)
    	return i;
    else
    	return -1;
}
//leetcode的解
public int pivotIndex(int[] nums) {
  int sum=0,leaftsum=0;
	for(int x : nums)
		sum+=x;
	for (int i = 0; i < nums.length; i++) {
		if(leaftsum==sum-leaftsum-nums[i])
			return i;
		leaftsum+=nums[i];
	}
	return -1;
}