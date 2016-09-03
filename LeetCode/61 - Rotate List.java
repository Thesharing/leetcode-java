/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
   public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0){
			return head;
		}
        int count = 1;
        ListNode emptyNode = new ListNode(0);
        emptyNode.next = head;
        ListNode nowNode = head;
        ListNode secondNode = emptyNode;
        while(nowNode.next != null){
        	if(--k <= 0){
        		secondNode = secondNode.next;
        	}
        	count ++;
        	nowNode = nowNode.next;
        }
        k = (k - 1) % count;
        if(k > 0){
        	k = count - k;
        	while(k > 0){
        		secondNode = secondNode.next;
        		k--;
        	}
        }
        if(secondNode != emptyNode){
        	nowNode.next = head;
        	head = secondNode.next;
        	secondNode.next = null;
        }
        return head;
    }
}