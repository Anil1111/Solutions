/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode RemoveElements(ListNode head, int val) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        while(head != null){
            if (head.val == val) prev.next = head.next;
            else prev = head;
            head = head.next;
        }
        return fake.next;
    }
}
