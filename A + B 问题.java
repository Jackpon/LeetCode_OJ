/*
A + B 问题 

给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。

样例
如果 a=1 并且 b=2，返回3
*/

public static int aplusb(int a, int b) {
    while (b !=0) {//直到不产生进位结束
    	int _a = a ^ b;
        int _b = (a&b)<<1;
        a = _a ;
        b = _b;
	}
    return a;
}

//递归
public static int aplusb(int a, int b) {
    if(a==0)
    	return b;
    if(b==0)
    	return a;
	int _a = a ^ b;
    int _b = (a&b)<<1;
    return aplusb(_a, _b);
}