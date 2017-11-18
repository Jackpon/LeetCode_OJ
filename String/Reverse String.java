/*
344. Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/
public String reverseString(String s) {
    int len=s.length();
	char []b=new char[len];
	for (char a : s.toCharArray()) {
		b[len-1] = a;
		len--;
	}
    String end = new String(b);
    return end;
}