/*
71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

#题意：
	"."表示当前目录； ".."表示上级目录
*/

class Solution {
    public String simplifyPath(String path) {
       ArrayDeque<String> stack = new ArrayDeque<>();
        String []sum = path.split("/");
        for (int i = 0; i < sum.length; i++) 
            if(!sum[i].equals("") && sum[i].equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!sum[i].equals("") && !sum[i].equals(".") && !sum[i].equals(".."))
                stack.push(sum[i]);
        
        String value="";
        if(stack.isEmpty())
			value = "/";
        while(!stack.isEmpty()) {
        	value = "/"+stack.pop()+value;
        }
		
		return value;
    }
}
