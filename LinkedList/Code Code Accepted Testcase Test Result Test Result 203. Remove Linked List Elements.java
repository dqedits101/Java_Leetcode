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
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val == val) {
            head = head.next;
        }

        ListNode Current = head;

        while(Current!=null && Current.next!= null) {
            if (Current.next.val == val) {
                Current.next = Current.next.next;
            }
            else {
                Current = Current.next;
            }
        }
        return head;
    }
}
