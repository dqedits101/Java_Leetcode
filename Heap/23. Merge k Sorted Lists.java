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
        // The PriorityQueue now has a comparator to order ListNodes by their 'val' field.
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}
