/*
485. Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

*/

/*
Intuition:
	int max_num =0，value=0;
遍历数组，如果元素值是1，++value；否则max_num=max(value,max_num) and value=0;遍历结束后，max_num就是结果
*/

public int findMaxConsecutiveOnes(int[] nums) {
    int max_num =0,value=0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i]==1) {
			++value;
		}else {
			max_num=Math.max(value,max_num);
			value=0;
		}
	}
	max_num=Math.max(value,max_num);
	return max_num;
}