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
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int c = 0;
        while(l1 !=null || l2!= null || c != 0){
            int v1 = (l1!=null) ? l1.val : 0;
            int v2 = (l2!=null) ? l2.val : 0;
            int sum = v1 + v2 + c;
            c = sum /10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            l1 = (l1!=null)?l1.next : null;
            l2 = (l2!=null)?l2.next :null;
        }
        return dummy.next;
    }
}
