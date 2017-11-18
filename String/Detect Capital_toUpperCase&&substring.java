/*
520. Detect Capital

Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

A: 65 a: 97 两者相差32，共有26个字母
*/

//直接暴力
public static boolean detectCapitalUse(String word) {
    char zm[] = word.toCharArray();
    boolean status = true;
    if(zm.length==1)
    	return status;
	if(zm[0] <= 'Z' && zm[1] <= 'Z') { 
		for (int i = 2; i < zm.length; i++) 
			if(zm[i] >'Z') {
				status = false;
				break;
			}
	}
	else if(zm[0] <= 'Z' && zm[1] > 'Z') { 
		for (int i = 2; i < zm.length; i++) 
			if(zm[i] <='Z') {
				status = false;
				break;
			}
	}	
	else if(zm[0] > 'Z') { 
		for (int i = 1; i < zm.length; i++) 
			if(zm[i] <='Z') {
				status = false;
				break;
			}
	}	
	
    return status;
}

//使用string内置函数
public boolean detectCapitalUse(String word) {
    if (word.length() < 2) return true;
    if (word.toUpperCase().equals(word)) return true;
    if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
    return false;
}
/*
substring
返回一个新字符串，它是此字符串的一个子字符串。
该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符。

"hamburger".substring(4, 8) returns "urge"
*/