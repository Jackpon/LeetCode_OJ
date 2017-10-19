/*
496. Next Greater Element I

You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements
 are subset of nums2. Find all the next greater numbers for nums1's elements in the
  corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its 
right in nums2. If it does not exist, output -1 for this number.

#题意：
	给定两个数组（没有重复）nums1 和 nums2 ,nums1 是nums2的子集。
	找到nums1中每个元素的在nums2中的下一个比其大的值。
	nums1中的x的下一个大的值是该数字x在nums2中，右边的比其大的一个值。如果不存在，返回-1。
*/

//直接暴力枚举
public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	int a[] =new int[nums1.length];
	int k =0 ,status=0;
	
	for (int i = 0; i < nums1.length; i++) {
		status = 0;
        
		for (int j = 0; j < nums2.length; j++) 
			if(nums1[i] == nums2[j]) 
				for (int j2 = j; j2 < nums2.length; j2++) 
					if(nums2[j2] > nums1[i]) {
						a[k++] = nums2[j2];
						status = -1;
						break;
					}
				
		if(status==0) 
			a[k++]=-1;	
	}
	return a;
}