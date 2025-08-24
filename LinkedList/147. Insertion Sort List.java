class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        List<Integer> arr = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            arr.add(current.val);
            current = current.next;
        }

        for (int i = 1; i < arr.size(); i++) {
            int currVal = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > currVal) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, currVal);
        }

        current = head;
        for (int i = 0; i < arr.size(); i++) {
            current.val = arr.get(i);
            current = current.next;
        }

        return head;
    }
}
