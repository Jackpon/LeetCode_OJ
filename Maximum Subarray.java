/*
53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

#this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
the paragraph below was copied from his paper (with a little modifications)
*/
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}
