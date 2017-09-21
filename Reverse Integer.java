/*
7. Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321


If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/
//思路其实很简单，注意上面的一些负数和超范围数的处理，然后问题就只是数字与字符的转换
public int reverse(int x) {
    int value=0,j=0;
	char [] sum = Integer.toString(x).toCharArray();
	
	for (int i = 0; i < sum.length; i++) {
		if(sum[i] == '-') 
			continue;		
		
		value += (sum[i] - '0') * Math.pow(10, j++);
	} 
	if(value == 2147483647)
		return 0;
	
    if (x < 0) 
    	value = - value;
		
    return value;
}

//当然我们还可以运用数学运算符 ' % 和 / ' 的特点，这样就显得更简单更有效率。
public int reverse(int x) {
	long value = 0;
	while(x != 0){
		value = value*10 + x%10;
		x = x/10;
		if(value> Integer.MAX_VALUE || value < Integer.MIN_VALUE)
			return 0;                
	}
    return (int)value;    
}