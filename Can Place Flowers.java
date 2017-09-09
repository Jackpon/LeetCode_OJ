/*
605. Can Place Flowers

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, 
flowers cannot be planted in adjacent plots - they would compete for water and both would die.
Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.

*/

/*
比较当前位置左右两边的数是否为0且当前位置是0，是count++；
但最重要的是处理好首尾两端，eg：[0,0,1,0,0];以及当len<=3的情况
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
     int count=0,len=flowerbed.length;
	 //处理len<=3 and 首尾两端 的情况
        	if (len==1 && flowerbed[0]==0) {
				return 1>=n;
			}
        	if (len==1 && flowerbed[0]==1) {
				return 0>=n;
			}
        	
        	if (flowerbed[0]==0 && flowerbed[1]==0) 
        	{	
        		count++;
        		flowerbed[0]=1;
        	}
        	if (flowerbed[len-1]==0 && flowerbed[len-2]==0) 
        	{	
        		count++;
        		flowerbed[len-1]=1;
        	}
	//len>=3 的情况
        	for (int i =1; i < len-1 && len>=3; i++) {
				if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0)
				{	
					flowerbed[i]=1;	
					count++;
				}
        	}
        	
        	return count>=n;
    }
}
