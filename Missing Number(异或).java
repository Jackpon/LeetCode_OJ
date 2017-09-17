/*
268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?

大意就是在{0, 1, 2, ..., n}找出遗失的数字，如果没有遗失return n+1；
*/

//二分搜索
public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    int min = 0, max = nums.length - 1;
    while(min < max){
        int mid = (min + max) / 2;
        // 没错位，在右边；有错位，则在左边
        if(mid == nums[mid]){
            min = mid + 1;
        } else {
            max = mid - 1;
        }
    }
    // 如果没有错位，则返回最后一个数加1
    return nums[min] == min ? min + 1 : min;
}

/*
异或运算:a^b^b=a;异或两次相同数字b，将得到原来数字a
运算法则：1^1=0; 1^0=1; 0^0=0;(异或是二进制运算符)
eg：2^3 =2(十进制) -> 10^11 = 1 (二进制)
*/
public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;
}