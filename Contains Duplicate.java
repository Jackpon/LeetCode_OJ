/*
217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
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



/*
219. Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct 
indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
between i and j is at most k.
*/

//第一遍：Time Limit Exceeded 
public boolean containsNearbyDuplicate(int[] nums, int k) {
    boolean status = false;
    for (int i = 0; i < nums.length-1; i++) {
        for (int j = i+1; j < nums.length; j++) {
        	if(j-i > k) 
                    break;
            if (nums[i] == nums[j] && j-i <=k) {
                status = true;
                break;
            }
        }
    }
    return status;
}

/*
既然第一种算法该优化的也优化了，还是不行，那就只能改变思路了（其实也没有改变思路，只是采用了set集合）,
可以采用set集合，因为它有这个特性：
如果 set 中尚未存在指定的元素，则添加此元素；如果此 set 已经包含该元素，则该调用不改变此 set 并返回 false。
*/

public static boolean containsNearbyDuplicate(int[] nums, int k) {
	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < nums.length; i++) {
		if(i>k) set.remove(nums[i-k-1]);
		if(!set.add(nums[i])) return true;
	}
	return false;
}