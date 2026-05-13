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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null , nextnode = null;

        while (temp != null) {
        ListNode kth = getKth(temp , k);
        if (kth == null) {
            // considering either less than k nodes in start or end..if end then 
            if (prev != null) {
                prev.next = temp;
            }
            break;
        }
        nextnode = kth.next;
        kth.next = null;
        ListNode newHeadKgroup = reverseLL (temp);
        if (head == temp) {
            //first k nodes
            head = newHeadKgroup;
        }
        else {
            //in between nodes
            prev.next = kth;
        }
        prev = temp;
        temp = nextnode;
        }
        return head;
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode n = temp.next;
            temp.next = prev;
            prev = temp;
            temp = n;
        }
        return prev;
    }
    public static ListNode getKth (ListNode head , int k) {
        k -= 1;
        while (head != null && k >0) {
            k--;
            head = head.next;
        }
        return head;

    }
} 
