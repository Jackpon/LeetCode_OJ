/*
674. Longest Continuous Increasing Subsequence

Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
Note: Length of the array will not exceed 10,000.
*/

/*
Intuition:
    计算相邻的差，如果大于0，前进直至遇到小于0，记录长度，以此类推，遍历完数组，len = max(len, i)；
*/


public int findLengthOfLCIS(int[] nums) {
   //构造数组sum，用于存放数组nums的差值
    int []sum = new int[nums.length+1];
    int []max_num = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
        sum[i] = nums[i]  - nums[i-1];
    }
    //对数组sum操作
    int len = 0, j = 0, status=0;
    for (int i = 1; i < nums.length; i++) {
        if(sum[i] > 0) 
            len++;
        else {
            max_num[++j] = len;
            len = 0;
        }       
    }
    
    //遍历找出最大子序列长度
    for (int i = 0; i < max_num.length; i++) {
        len = Math.max(max_num[i],len);
    }
    if(nums.length <= 0)
        len = -1;
    return len+1;
}    



//上面代码空间占用太多，删掉sum数组，直接在nums操作

public static int findLengthOfLCIS(int[] nums) {
    //构造数组sum，用于存放数组nums的差值
    int []max_num = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
        nums[i-1] = nums[i]  - nums[i-1];
    }
    
    int len = 0, j = 0;
    for (int i = 0; i < nums.length-1; i++) {
        if(nums[i] > 0) 
            len++;
        else {
            max_num[++j] = len;
            len = 0;
        }       
    }
    
    //遍历找出最大子序列长度
    for (int i = 0; i < max_num.length; i++) {
        len = Math.max(max_num[i],len);
    }
    if(nums.length <= 0)
        len = -1;
        
    return len+1;
}