/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int pr = 101;
        ListNode current = head;
        ListNode prives = head;
        while (current != null) {
            if (current.val == pr) {
                prives.next = current.next;
            } else {
                prives = current;
                pr = current.val;
            }
            current = current.next;
        }
        return head;
    }
}