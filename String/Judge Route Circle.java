/*
657. Judge Route Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by 
a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true

Example 2:
Input: "LL"
Output: false
*/
/*
思路：
	将字符串moves转换为可抵消的数字数组b[]，建立stack，将数组b[i]元素添加进去，
	进入前判断stack是否包含b[i]的相反数-b[i]，有的话移除-b[i]，直至遍历完数组b[i]
	最后判断stack是否为空。
*/
public boolean judgeCircle(String moves) {
	//将字符串moves转换为可抵消的数字数组b[]
    char []a=moves.toCharArray();
    int []b=new int[a.length];
    for (int i = 0; i < a.length; i++) {
		if(a[i]=='L')
			b[i]=1;
		if(a[i]=='R')
			b[i]=-1;
		if(a[i]=='U')
			b[i]=2;
		if(a[i]=='D')
			b[i]=-2;
	}
	//建立stack，将数组b[i]元素添加进去并判断
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < b.length; i++) {
		if (stack.isEmpty()) 
			stack.push(b[i]);
		else {
			if(stack.contains(-b[i])) {
				stack.remove(stack.indexOf(-b[i]));
				continue;
			}
			stack.push(b[i]);
		}
	}
	//stack为空则true
    if(stack.isEmpty())
    	return true;
    else
    	return false;
}

/*
上面代码勉强通过，时间：O(logn),空间有两个数组+一个stack，显然效率太低！
其实，我们只需提取最核心的部分，也就是：L->R 、 U->D；只要成对出现就是true
*/
public boolean judgeCircle(String moves) {
	int x=0,y=0;
    for (char s : moves.toCharArray()) {
		if(s=='L')
			x++;
		if(s=='R')
			x--;
		if(s=='U')
			y++;
		if(s=='D')
			y--;
	}
	return x==0 && y==0;
}