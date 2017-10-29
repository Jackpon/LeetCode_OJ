/*
169. Majority Element

Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always
 exist in the array.

#思路：
	利用set先过滤掉重复元素并将set转换为数组a[]，两层for循环统计数组a[]各元素出现
	次数，最后找出出现次数最多的元素即可
*/
public int majorityElement(int[] nums) {
	//利用set先过滤掉重复元素并将set转换为数组a[]
    Set<Integer> set = new LinkedHashSet<>();
	for (int i = 0; i < nums.length; i++) 
		set.add(nums[i]);
	Integer []a = new Integer[set.size()];
	set.toArray(a);
    //两层for循环统计数组a[]各元素出现次数
	int k=0,z=0;
	int []sum = new int[set.size()];
	for (int i = 0; i < a.length; i++) {
		 k=0;
		for (int j = 0; j < nums.length; j++) 
			if (a[i] == nums[j]) 
				k++;
		 sum[z++] = k;
	}
    //最后找出出现次数最多的元素并return
	int value=0;
	for (int i = 0; i < sum.length; i++) 
		if(sum[i]>value) {
			value = sum[i];
			z = i;
		}
	return a[z];  
}

/*
下面是获赞最多的代码
#思路：
	先把major设置为num[0]，遍历比较是否等于major
	是的，count++；否则count--，如果count==0，
	说明num[i]出现次数大于原先的major，所以替换
*/ 
public int majorityElement(int[] num) {
    int major=num[0], count = 1;
    for(int i=1; i<num.length;i++){
        if(count==0){
            count++;
            major=num[i];
        }else if(major==num[i]){
            count++;
        }else count--;
        
    }
    return major;
}