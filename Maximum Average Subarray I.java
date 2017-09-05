/*
643. Maximum Average Subarray I

Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/


//题意大致是：给定一个长度为n的数组以及k，求最大的连续子数组的平均值。
//(1)下面的代码思路是对的，但是运行数据很多的数组会超时，效率不高
class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int len=nums.length;
        int j=1;//用于刻度k的移动
        double sum1=0;
        
        for (int i =0; i < k; i++) {
			sum1+=nums[i];
		}
        double value=sum1;
        sum1=0;
        
        while(k+j<=len) {
        for (int i =j; i < k+j; i++) {
			sum1+=nums[i];
		}
        value=Math.max(value,sum1);
        sum1=0;
        ++j;
     } 
        return value/k;
    }
}

//(2)下面是(1)代码的简洁高效版
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
        sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}



