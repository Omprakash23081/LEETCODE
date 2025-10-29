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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0 ;
        ListNode res = null;
        ListNode tail = null ;
        while(l1!=null && l2!=null){
               int val = l1.val+l2.val + carry ;
                ListNode newNode = new ListNode((val%10) , null);
               if(res==null){
                 tail = res = newNode ;
               }else{
                  tail.next = newNode ;
                  tail = newNode ;
                }
                carry = val /10 ;
               l1=l1.next;
               l2=l2.next;
        }
        while(l1!=null){
            int temp = l1.val+carry ;
            ListNode newNode = new ListNode(temp%10, null);
            tail.next = newNode;
            tail = newNode ;
            carry = temp/10;
            l1 = l1.next;
        }
          while(l2!=null){
            int temp = l2.val+carry ;
            ListNode newNode = new ListNode(temp%10, null);
            tail.next = newNode;
            tail = newNode ;
            carry = temp/10;
            l2=l2.next;
        }
        if(carry>0){
             ListNode newNode = new ListNode(carry, null);
            tail.next = newNode;
            tail = newNode ;
        }
        return res ;
    }
}