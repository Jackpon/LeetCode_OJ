/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that 
they add up to a specific target number.The function twoSum should return indices of the two numbers 
such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

思路很简单，也不知道怎么啦，我TM刚开始在for循环里把 numbers.length-1 写成 num.length-1;
浪费了好多时间，敲代码还是要细心
*/
public int[] twoSum(int[] numbers, int target) {
    int []num = new int[2];
    int value;
    for (int i = 0; i < numbers.length-1; i++) {
        value = target - numbers[i];
        if (Arrays.binarySearch(numbers,i+1,numbers.length,value) >i) {
            num[0] = i+1;
            num[1] = Arrays.binarySearch(numbers,i+1,numbers.length, value)+1;
            break;
        } 
    }
    return num;
}