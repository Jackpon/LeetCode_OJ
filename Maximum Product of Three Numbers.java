/*
628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
*/

//思路其实很简单，将数组排好序，比较sum1和sum2就行
class Solution {
    public int maximumProduct(int[] nums) {
        int len=nums.length;
		Arrays.sort(nums);
		int sum1=nums[0]*nums[1]*nums[len-1];
		int sum2=nums[len-1]*nums[len-2]*nums[len-3];
		int maxnum=Math.max(sum1,sum2);
		return maxnum;
    }
}