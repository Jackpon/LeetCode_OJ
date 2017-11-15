/*
680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True

Explanation: You could delete the character 'c'.
*/

public static boolean validPalindrome(String s) {
	boolean status=true;
  	char[] sum = s.toCharArray();
  	int i =0 ,j=sum.length-1,count=0;
  	while (i<j) {
		if(sum[i]!=sum[j]) {
			if(sum.length<3)
			{
				status=true;
				break;
			}
			if(sum[i+1]==sum[j]&&sum[i+2]==sum[j-1])
				j++;
			else
				i--;
			
			count++;
			if(count>1)
			{
				status=false;
				break;
			}
		}
	
	i++;j--;
	}
  return status;
}