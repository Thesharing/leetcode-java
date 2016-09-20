/*

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode nowNode = head;
        ListNode tempNode = null;
        ListNode lastNode = null;
        if(head == null){
            return head;
        }
        if(head.next != null){
            tempNode = head.next.next;
            head.next.next = head;
            head = head.next;
            head.next.next =tempNode;
        }
        else
            return head;
        if(head.next.next != null){
            lastNode = head.next;
            nowNode = head.next.next;
            while(nowNode != null && nowNode.next!= null){
                tempNode = nowNode.next.next;
                nowNode.next.next = nowNode;
                lastNode.next = nowNode.next;
                nowNode.next = tempNode;
                lastNode = nowNode;
                nowNode = nowNode.next;
            }
        }
        return head;
    }
}