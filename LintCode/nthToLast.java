/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        ListNode node1 = head;
        for(int i=0;i<n;i++) node1 = node1.next;
        
        ListNode node2 = head;
        while(node1 != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return node2;
    }
}

