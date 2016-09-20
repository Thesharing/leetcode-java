/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     ListNode resNode = new ListNode(0);
     ListNode nowNode1 = l1;
     ListNode nowNode2 = l2;
     ListNode nowNode3 = resNode;
     while(nowNode1 != null && nowNode2 != null){
       if(nowNode1.val < nowNode2.val){
         nowNode3.next = nowNode1;
         nowNode1 = nowNode1.next;
         nowNode3 = nowNode3.next;
       }
       else{
         nowNode3.next = nowNode2;
         nowNode2 = nowNode2.next;
         nowNode3 = nowNode3.next;
       }
     }
     if(nowNode1 != null){
       nowNode3.next = nowNode1;
     }
     if(nowNode2 != null){
       nowNode3.next = nowNode2;
     }
     resNode = resNode.next;
     return resNode;
   }
}