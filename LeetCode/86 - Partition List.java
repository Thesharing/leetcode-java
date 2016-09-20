/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode nowLow = low;
        ListNode nowHigh = high;
        ListNode now = head;
        while(now != null){
            if(now.val < x){
                nowLow.next = now;
                nowLow = nowLow.next;
            }
            else{
                nowHigh.next = now;
                nowHigh = nowHigh.next;
            }
            now = now.next;
        }
        nowLow.next = high.next;
        nowHigh.next = null;
        return low.next;
    }
}