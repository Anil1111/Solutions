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
        ListNode nodeA = headA, nodeB = headB;
        int countA = 0, countB = 0;
        while(nodeA != null && nodeA.next != null){
            nodeA = nodeA.next;
            countA++;
        }
        while(nodeB != null && nodeB.next != null){
            nodeB = nodeB.next;
            countB++;
        }
        if (nodeA != nodeB) return null;
        
        
    }
}
