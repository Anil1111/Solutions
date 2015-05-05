/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode fake = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = fake.next;
            fake.next=head;
            head = next;
        }
        return fake.next;
    }
}
