package Nov16;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int data) {
        this.val = data;
        next = null;
    }
}

public class MergeSortedLists {
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
