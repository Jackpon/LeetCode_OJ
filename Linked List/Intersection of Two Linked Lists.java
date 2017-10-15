/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>  set =new HashSet<>();
        //将headA添加到set
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        //比较headB，不同则return
	     while(headB != null) {
	    	 if(set.contains(headB))
	    		 return headB;
	    	 headB = headB.next;
	     }
	    return null;
    }
}