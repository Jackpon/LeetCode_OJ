/*
258. Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

public int addDigits(int num) {
    if(num < 0)
		return num;
    int value=0;
	char [] sum = Integer.toString(num).toCharArray();
	for (int i = 0; i < sum.length; i++) 
		value += (sum[i] - '0');
	
	if(sum.length==1)
		return value;
	return	addDigits(value);
}

//数学取余
public int addDigits(int num) {
       return num==0?0:(num%9==0?9:(num%9));
    }