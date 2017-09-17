/*
88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int j=0;
    if(n != 0) 
    	for (int i = m; i < m+n; i++) 
			nums1[i] = nums2[j++];
    Arrays.sort(nums1);
}