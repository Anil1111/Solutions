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
    public ListNode partition(ListNode head, int x) {
        //handle null list, x >= all nodes
        ListNode left = new ListNode(-1), right = new ListNode(-1),
            lLast = left, rLast = right;
        
        while(head != null){
            if (head.val < x){
              lLast.next = head;
              lLast = head;
            } 
            else {
                rLast.next = head;
                rLast = head;
            }
            head = head.next;
        }

        rLast.next = null;
        lLast.next = right.next;
        return left.next;
    }
}
