/*
9. Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

//利用栈
public boolean isPalindrome(int x) {
    if(x<0)
        return false;
    LinkedList<Integer> palindrome = new LinkedList<>();
    int y = x;
    while(x != 0){
        palindrome.push(x%10);
        x = x/10;
    }
    
    while(y != 0 && ! palindrome.isEmpty()){
        if(y%10 != palindrome.pop())
            return false;
        y = y/10;
    }
    return true;
}


//将x转换为char数组
public boolean isPalindrome(int x) {
    if(x<0)
        return false;
    char [] sum = Integer.toString(x).toCharArray();
    int i=0,j=sum.length-1;
    while(i<j){
        if(sum[i] != sum[j])
            return false;
        i++;
        j--;
    }
    return true;
}