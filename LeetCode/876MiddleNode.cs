/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MiddleNode(ListNode head) {
        int count = 0;
        var node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        
        node = head;
        for(int i=0;i<count/2;i++){
            node = node.next;
        }
        
        return node;
    }
}
