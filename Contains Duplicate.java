/*
217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

 public boolean containsDuplicate(int[] nums) {
       Arrays.sort(nums);
	        boolean status=false;
	        int count=0;
	        
	        for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) { 
					if (nums[i]==nums[j]) 
						count++;
					if(count>1) {
						status=true;
						break;
					}
				}
				
				count=0;
			}
	        
	        return status;
    }
	
//上面的暴力O(n^2)比较很显然是超时的，来个O(n)

 public static boolean containsDuplicate(int[] nums) {
		 	Arrays.sort(nums);
	        boolean status=false;
	        for (int i = 1; i < nums.length; i++) {
				if(nums[i] == nums[i-1]) {
					status = true;
					break;
				}
			}
 
	        return status;
	    }