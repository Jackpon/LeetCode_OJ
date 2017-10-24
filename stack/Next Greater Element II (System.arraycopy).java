/*
503. Next Greater Element II

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
*/
//题意：从数组中从左到右找到比sum[i]大的值
public static int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];
    int k = 0, status;
    
    for (int i = 0; i < nums.length-1; i++) {
    	status = 0;
//        	第一遍for，筛选sum[i]后的值
    	for (int j = i+1; j < nums.length; j++) 
		if(nums[j] > nums[i]) {
			status = 1;
			a[k++] = nums[j];
			break;
		}
//        	第二遍，筛选sum[i]前的值
    	for (int j = 0; j < i && status==0; j++) 
    		if(nums[j] > nums[i]) {
				status = 1;
				a[k++] = nums[j];
				break;
			}
		
//        	如果都找不到，那就是-1
    	if(status == 0)
    		a[k++] = -1;
    } 
    status = 0;
//        对最后的一个数进行处理
    for (int i = 0; i < nums.length-1; i++) 
		if(nums[i] > nums[nums.length-1]) {
			status = 1;
			a[k++] = nums[i];
			break;
		}
	if (status == 0 && nums.length != 0) 
		a[k++] = -1;
	
	return a;	
}

/*
代码不够简洁，我使用System.arraycopy（），构造doublenums[]
包含两个nums数据,这样就不需要回头来判断数组前面的值了
*/
public int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];
    int []doublenums = new int[2*nums.length];
    System.arraycopy(nums, 0, doublenums, 0, nums.length);
	System.arraycopy(nums, 0, doublenums, nums.length, nums.length);

    int k = 0, status;
    for (int i = 0; i < nums.length; i++) {
    	status = 0;
    	for (int j = i+1; j < doublenums.length; j++) 
    		if(doublenums[j] > nums[i]) {
    			status = 1;
    			a[k++] = doublenums[j];
    			break;
    		}
    	if(status == 0)
    		a[k++] = -1;
	}
	
	return a;	
}

/*
上面效率不高，空间和时间都是O(n^2)，而且调用System.arraycopy也会耗费一些时间，
让我们来优化下，可以用数学表达式 j%nums.length 来代替doublenums的作用
*/
public int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];

    int k = 0, status;
    for (int i = 0; i < nums.length; i++) {
    	status = 0;
    	for (int j = i+1; j < 2*nums.length; j++) 
    		if(nums[j%nums.length] > nums[i] && j%nums.length != i ) {
    			status = 1;
    			a[k++] = nums[j%nums.length];
    			break;
    		}
    	if(status == 0)
    		a[k++] = -1;
	}
	
	return a;	
}

/*
上面效率没提高多少，只是少用了一个空间,让我们使用stack来提高效率
#思路：
    构建栈stack，nums从 i = 2*nums.length-1（倒着来，也是难想到的顺着来就不行了）
    开始循环进行如下动作进栈：
    （1）：进栈前判断nums[i]是否大于stack.peek()，没有的话，
    将其Next Greater Element 设置为stack.peek()，然后入栈；
    （2）：大于的话，则stack.pop()，直到不大于或者为空。
    将其Next Greater Element 设置为stack.peek()，空着设置为-1，然后入栈；
*/

public static int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 2*nums.length-1; i > 0; i--) {
        if(stack.isEmpty()) {
            stack.push(nums[i%nums.length]);
            a[i%nums.length] = -1;
            continue;
        }
        if(nums[i%nums.length] < stack.peek()) {
            a[i%nums.length] = stack.peek();
            stack.push(nums[i%nums.length]);
        }
        if(nums[i%nums.length] >= stack.peek()) {
            while(!stack.isEmpty() && nums[i%nums.length] >= stack.peek())
                stack.pop();
            if(stack.isEmpty())
                a[i%nums.length] = -1;
            else 
                a[i%nums.length] = stack.peek();
            
            stack.push(nums[i%nums.length]);
            
        }
    }
    
    return a;   
}

/*
思路很好，但是实现过程太多if语句。效率太低，继续改进
将三种情况整合，
当!stack.isEmpty() && nums[i%nums.length时，只执行stack.pop()；
其他两种变成一个a>b?a:b表达式;
最后都执行 stack.push(nums[i%nums.length]);
*/
public static int[] nextGreaterElements(int[] nums) {
    int []a =new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 2*nums.length-1; i >=0; i--) {
         while(!stack.isEmpty() && nums[i%nums.length] >= stack.peek())
             stack.pop();
         a[i%nums.length] = stack.isEmpty() ? -1:stack.peek();
         stack.push(nums[i%nums.length]);
    }
    
    return a;   
}