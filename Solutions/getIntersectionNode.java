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
        while(nodeA != null && nodeA.next != null){
            nodeA = nodeA.next;
        }
        while(nodeB != null && nodeB.next != null){
            nodeB = nodeB.next;
        }
        if (nodeA == null || nodeA != nodeB) return null;
        
        //tortoise and rabbit algorithm
        ListNode tailB = nodeB.next;
        tailB.next = headB;
        nodeA = headA;
        nodeB = headA;
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next.next;
        }

        nodeA = headA;
        while(nodeA!=nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        ListNode joint = nodeA;
        tailB.next = null;
        
        return joint;
    }
}
