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
        int len = 0;
        //find length
        while(tmp != null) {
            tmp = tmp.next;
            len++;
        }
        //then remove N-n node
        int removeidx = len - n;
        if(removeidx == 0){
            return head.next;
        }
        int i =0;
        while(i != len - 1){
            if((i+1) == removeidx){
                tmp2.next = tmp2.next.next;
                break;
            }
            i++;
            tmp2 = tmp2.next;
        }
        return head;
    }
}
