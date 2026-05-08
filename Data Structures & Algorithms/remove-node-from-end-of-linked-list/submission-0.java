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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head, tmp2 = head;
        int N = 0;
        while( tmp != null){
        N++;
        tmp = tmp.next;
        }
        int i = 0;
        int removeidx = N - n; //node from starting
        if( removeidx == 0){
            return head.next;
        }
        while ( i != N-1){
             
           if ((i+1) == removeidx) { 
            tmp2.next = tmp2.next.next;
            break;
             }
            i++;
            tmp2 = tmp2.next;
        }
       
        return head;
    }
}
