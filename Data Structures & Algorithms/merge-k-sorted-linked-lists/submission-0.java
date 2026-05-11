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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {

            List<ListNode> mergeLists = new ArrayList<>();
            for (int i = 0 ;i < lists.length ; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i+1) < lists.length ? lists[i+1] : null;
                mergeLists.add(mergeList(l1,l2));
            }
            lists = mergeLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    private ListNode mergeList(ListNode l1 , ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tmp = dummy;
            while ( l1!=null && l2!=null) {
                if (l1.val < l2.val ) {
                    tmp.next=l1;
                    l1 = l1.next;
                }
                else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
           if (l1 != null) {
            tmp.next = l1;
           }  
           if (l2 !=null) {
            tmp.next = l2;
           }
           return dummy.next;                                                    
    } 
}
