/*
503. Next Greater Element II

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
*/
//题意：从数组中从左到右找到比sum[i]大的值
public static int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];
    int k = 0, status;
    
    for (int i = 0; i < nums.length-1; i++) {
    	status = 0;
//        	第一遍for，筛选sum[i]后的值
    	for (int j = i+1; j < nums.length; j++) 
		if(nums[j] > nums[i]) {
			status = 1;
			a[k++] = nums[j];
			break;
		}
//        	第二遍，筛选sum[i]前的值
    	for (int j = 0; j < i && status==0; j++) 
    		if(nums[j] > nums[i]) {
				status = 1;
				a[k++] = nums[j];
				break;
			}
		
//        	如果都找不到，那就是-1
    	if(status == 0)
    		a[k++] = -1;
    } 
    status = 0;
//        对最后的一个数进行处理
    for (int i = 0; i < nums.length-1; i++) 
		if(nums[i] > nums[nums.length-1]) {
			status = 1;
			a[k++] = nums[i];
			break;
		}
	if (status == 0 && nums.length != 0) 
		a[k++] = -1;
	
	return a;	
}