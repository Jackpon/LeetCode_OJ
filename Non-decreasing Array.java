/*
665. Non-decreasing Array

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 
4
 to 
1
 to get a non-decreasing array.

Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.

Note: The n belongs to [1, 10,000].
*/

/*
	我原先的想法就是内外两层循环遍历访问数组，找出不符合这一条件（array[i] <= array[i + 1]）的值，并count++；当count>1时，那么就返回false，
但代码实现过程中并不能顾全所有的情况，没能AC；
	后来参考了下别人的code ，发现事情没那么简单，当array[i-1] > array[i]时，我们使array[i-1] = array[i]，
但这样如果array[i-2]不满足小于array[i]，就行不通了，所以就要分成两种情况了，if(nums[i-2] <= nums[i]) 我们就可以使array[i-1] = array[i]，
else，我们执行array[i] = array[i-1]，这样做的目的就是使结果返回false；
*/

public boolean checkPossibility(int[] nums) {
	int count=0; 		//记录是否只需最多一个修改就使数组符合Non-decreasing Array
	for (int i = 1;i <nums.length && count <=1 ;++i ) {
	    	if (nums[i-1] > nums[i]) {
	    		count++;
	//i-2表示数组前两个只需进行nums[i-1] = nums[i]操作；如果没有该条件，后续不管数组元素大小如何，nums[i] > nums[i-1]会一直存在
	    		if(i-2< 0 || nums[i-2] <= nums[i])  
	    			nums[i-1] = nums[i];
	    		else
	    			nums[i] = nums[i-1];
	    	}
	    }
	return count<=1;
}