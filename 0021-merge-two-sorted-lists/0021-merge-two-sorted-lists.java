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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode res = null;
        ListNode tail =null;
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                ListNode newNode = new ListNode(list2.val);
                if(res==null){
                    tail=res= newNode;
                } else{
                   tail.next = newNode;
                   tail = newNode;
                } 
                list2= list2.next; 
            }else{
                ListNode newNode = new ListNode(list1.val);
                if(res==null){
                    tail=res= newNode;
                } else{
                   tail.next = newNode;
                   tail = newNode; 
                } 
                list1= list1.next;   
            }
        }
        if(list1!=null) tail.next=list1;
        if(list2!=null) tail.next=list2;
        return res;
    }
}