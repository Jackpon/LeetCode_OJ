/*
557. Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
*/
class Solution {
	//置反单个单词
    public static String reverseString(String s) {
    	int len=s.length();
    	char []b=new char[len];
    	for (char a : s.toCharArray()) {
			b[len-1] = a;
			len--;
		}
        String end = new String(b);
        return end;
    }
    //置反整条字符串
    public String reverseWords(String s) {
        char a[] = s.toCharArray();
        //确定单个单词个数
    	int count=1;
    	for (int i = 0; i < a.length; i++) 
			if(a[i]==' ')
				count++;
		int j=0;
		//设置数组b，用来存放置反后的单词
		String b[] = new String[count];
		for (int i = 0; i < count; i++) {
			b[i] = new String();
		}
    	
    	for (int i = 0; i < b.length; i++) {
    		while(j < a.length) {
        		if(a[j]==' ') {
        			b[i] = reverseString(b[i])+" ";
        			j++;
        			break;
        		}
        		b[i]+=a[j];
    			j++;
    		}
		}
		//处理最后一个单词
    	b[count-1] = reverseString(b[count-1]);
    	String string = new String();
    	for (int i = 0; i < b.length; i++) 
			string+=b[i];
    	
		return string;
    }
}