/*
682. Baseball Game

You're now a baseball game point recorder.
Given a list of strings, each string can be one of the 4 following types:
Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

Example 1:
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.

Example 2:
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.

Note:
The size of the input list will be between 1 and 1000.
Every integer represented in the list will be between -30000 and 30000.

思路：其实很简单，只要搞清楚题意即可；建立数组sum用来存储最后添加的数字，最后遍历sum统计和即可
*/

public int calPoints(String[] ops) {
	int []sum = new int[ops.length];
    int k = 0,sums =0;
    for (int i = 0; i < ops.length; i++) {
		if (ops[i].equals("+")) {
			sum[k] = sum[k-1] + sum[k-2];
			k++;
		}
		else if (ops[i].equals("D")) {
			sum[k] = 2 * sum[k-1];
			k++;
		}
		else if (ops[i].equals("C")) {
			k --;
			sum[k] = 0;
		}
		else 
			sum[k++] = Integer.parseInt(ops[i]);
		
	}
        
    for (int i = 0; i < sum.length; i++) 
        	sums += sum[i];
		
    return sums;
}


//利用栈,上面的思路其实抽象出来就是栈
public int calPoints(String[] ops) {
	LinkedList<Integer> stack = new LinkedList<>();
	int a,b,sum=0;
	for (int i = 0; i < ops.length; i++) {
		if (ops[i].equals("+")) {
			a = stack.pop();
			b = stack.pop();
			stack.push(b);
			stack.push(a);
			stack.push(a+b);
		}
		else if (ops[i].equals("D")) {
			a = stack.pop();
			stack.push(a);
			stack.push(2*a);
		}
		else if (ops[i].equals("C")) {
			stack.pop();
		}
		else 
			stack.push(Integer.parseInt(ops[i]));
		
	}
	while(!stack.isEmpty())
		sum += stack.pop();
	return sum;
}

//可以看出，效率没有数组高，思路也差不多，当然栈有个好处就是不用处理下标