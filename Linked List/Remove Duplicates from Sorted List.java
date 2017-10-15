/*
83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;//此时list对象相当于head对象的引用
        while(list != null && list.next != null){
            if(list.next.val == list.val)
                list.next =list.next.next;
            else
                list = list.next;
        }
        return head; //list记录的是head的一个地址,所以return list 是错误的
    }
}

/*
ArrayList<Integer> arrayList =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        
        ArrayList<Integer> bArrayList =arrayList;
        System.out.println(bArrayList);
        bArrayList.add(5);
        System.out.println(arrayList);
        System.out.println(bArrayList);
*/