/*
206. Reverse Linked List

Reverse a singly linked list.

#思路：
        将head元素里的各个指针方向设为相反反向，
        然后再让pre指向head最后一个指针就行
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
            pre = cur; //更新pre指向cur
            cur = nexttemp; //更新cur
        }
        return pre;
    //为什么在这return cur/head 结果不一样：因为head指向第一个元素而cur指向最后一个
    }
}


/*
再来个递归算法

递归版本稍微复杂一些，关键是向后退。假设列表的其余部分已经被颠倒了，现在如何扭转前面部分？
我们假设列表是：n 1 →...→n k-1 →n k →n k + 1 →...→n m →Ø
从节点n k + 1到n m的假设已经被反转，并且在节点n k处。
n 1 →...→n k-1 → n k →n k + 1 ←...←n m
我们希望n k + 1的下一个节点指向n k。
所以，n k .next.next = n k ;
要小心，n 1的下一个必须指向Ø。如果您忘记了这一点，您的链接列表就会有一个循环。
*/
//C++
ListNode* reverseList(ListNode* head) {
    if (head == null || head->next == null) return head;
    ListNode* p = reverseList(head->next);
    head->next->next = head;
    head->next = null;
    return p;
}

//Java实现
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}