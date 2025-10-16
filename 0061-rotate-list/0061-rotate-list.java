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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)return head;
        ListNode current = head;
        int size =0;
        while(current !=null){
            size++;
            current = current.next;
        }
        if(0==k%size)return head;
        size = size -(k%size);  
        current = head;
        while(--size !=0){
            current = current.next;
        }
        ListNode temp = current.next;
        ListNode res = current.next;
        current.next = null;
        while(temp!=null && temp.next !=null) temp = temp.next; 
        temp.next = head; 
        return res;
    }
}