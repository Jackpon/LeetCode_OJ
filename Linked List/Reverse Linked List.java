/*
206. Reverse Linked List

Reverse a singly linked list.
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        //通过改变指针指向
        while(cur != null ){
            ListNode nexttemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nexttemp;
        }
        return pre;//为什么在这return cur/head 结果不一样
    }
}