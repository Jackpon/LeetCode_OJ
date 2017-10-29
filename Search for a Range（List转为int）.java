/*
34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
#题意：
		找到数组nums中值等于target的第一个和最后一个
*/
public int[] searchRange(int[] nums, int target) {
        int a[]={-1,-1};
        int i = 0, j = nums.length-1;
        boolean status1 = false,status2 = false;
		while((!status1 || !status2) && i<=j){
            if(nums[i] != target)
                ++i;
            else
            	status1 =true;
            
            if(nums[j] != target)
                --j;
            else 
            	status2 =true;
        }
		if(i<=j && status1){
            a[0] = i;
            a[1] = j;
        }
        return a;	
    }
/*
List转为int(拓展)
LinkedList<Integer> linkedList = new LinkedList<>();	
		int []a = new int[linkedList.size()];
		for (int i = 0; i < linkedList.size(); i++) 
			a[i] = linkedList.get(i);


Integer []a = new Integer[set.size()];
        set.toArray(a);
*/