/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public boolean isValid(String s) {
    char []sum=s.toCharArray();
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < sum.length; i++) {
    	if(stack.isEmpty())
    		stack.push(sum[i]);
    	else if(sum[i] == stack.peek()+1 || sum[i] == stack.peek()+2)
			stack.pop();
		else
			stack.push(sum[i]);
	}
    if(stack.isEmpty())
    	return true;
    else 
    	return false;
}