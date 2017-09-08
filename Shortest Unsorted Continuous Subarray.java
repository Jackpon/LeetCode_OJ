/*
581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/

/*
(1)想这道题的时候，刚开始就想太复杂了，原先的思路是复制数组nums[]并sort()成snums[]，然后遍历数组nums[],比较nums[i]和snums[i]的值，如果不同则跳转到nums[i]在snums[i]所在位置,依次类推。
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
       	int b[] =new int[nums.length];
		 int variable=0,len=0;
		 for (int i = 0; i < nums.length; i++) {
			b[i]=nums[i];
		}
		 
		 Arrays.sort(b);

		 for (int i = 0; i < nums.length; i++) {
				if(b[i]==nums[i]) ++variable;
				else break;
			}
		 if (variable==nums.length) variable=1; 
		int j=0,count;//j：索引号
		 //遍历数组a[],比较两值
		 for (int i = 0; i < nums.length; ++i) {
			 //为什么int i=j，j的值不能传递给i？
				if (nums[i] >=b[i]) { 
					count=0;
					for (int k = 0; k < b.length; k++) {
						if(nums[i]==b[k])count++;
					}
					count=count-1;
					if(nums[nums.length-1]==nums[nums.length-2])count=count-1;
					i=Arrays.binarySearch(b, nums[i])+count;
					j=i;
				}
			}
		 len=j+1-variable;
	     return len;
    }
}
/*
(2)但实践后，很显然这样的思路并不抽象，实现过程很麻烦，不能顾全所有数据，而且很耗时间，结果也是错误的，只能被迫放弃，后来参考下了别人的思路，还是太naive了。
思路：复制数组nums[]并sort()成snums[]，比较两个数组不同的值，并记下最先的不同值的索引号：start；和最后的不同值的索引号：end；最后return (end - start >= 0 ? end - start + 1 : 0);
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
       	 int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
