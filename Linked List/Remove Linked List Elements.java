/*
203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;//去除头元素为val的
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) 
                curr.next = curr.next.next;
        // 注意，必须要有else，不然curr就变第二个‘2’； 例子： [1,2,2,1]
            else 
                curr = curr.next;  //相当于指针的移动
        return head;
    }
}