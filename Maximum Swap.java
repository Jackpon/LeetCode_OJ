/*
670. Maximum Swap

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Note:
The given number is in the range [0, 108]
*/

/*
Intuition:
   遍历数组，找出A[i]后的最大值max_num，以及max_num最后出现的下标index，if(max_num > A[i] && A[i] != max_num),
   那么就交换两者，并退出循环，否则继续遍历数组。
*/

public int maximumSwap(int num) {
    char[] A = Integer.toString(num).toCharArray();
	 int index=0;
	 char max_num ='0',value;
	 for (int i = 0; i < A.length-1; i++) {	//i<A.length-1
		 //找出A[i]后面的最大值
		 for (int j = i+1; j < A.length; j++) 
			 max_num = (char) Math.max(max_num, A[j]);
		 //找出最大值下标	 	
		 for (int j2 = i+1; j2 < A.length; j2++) 
			 if(A[j2] == max_num)
				 index = j2;
		 //上面的最大值和下标都已经找到，现在只需比较替换
		 if(max_num > A[i] && A[i] != max_num ) {
			 value = A[i];
			 A[i] = max_num;
			 A[index] = value;
			 break;
		 }
		 max_num ='0';
	}
	 
	return Integer.valueOf(new String(A)); 
}