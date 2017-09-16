/*
189. Rotate Array

Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

*/

/*
Intuition:
   题目的意思就是将最后一位移动到第一位，移动的次数为k，直接刷
*/
//Time complexity : O(n*k); Space complexity : O(1); 显然效率不高
 public void rotate(int[] nums, int k) {
    int len = nums.length; 
    int value, j =0 ; 
    k %= len;
    while(j != k) {
    	value = nums[len-1];
    	//所以数值向后移动一位
    	for (int j2 = len-1; j2 > 0; j2--) 
    		nums[j2]=nums[j2-1];
		
        nums[0] = value;
        ++j;
    }
    
}



/*
首先反转整个数组nums，然后反转nums(0,k-1)，最后反转nums(k, len-1)
Time complexity : O(n); Space complexity : O(1);
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}