/*
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.
判断是否是回文；建立栈来实现
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode he = head;
        LinkedList<Integer> palindrome = new LinkedList<>();
        while(head != null){
            palindrome.push(head.val);
            head = head.next;
        }
        while(he != null && ! palindrome.isEmpty()){
            if(he.val != palindrome.pop())
                return false;
            he = he.next;
        }
        return true;
    }
}



