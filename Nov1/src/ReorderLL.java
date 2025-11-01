class ListNode2{
    ListNode2 next;
    int val;
    public ListNode2(){}
    public ListNode2(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReorderLL {
    public void reorderLL(ListNode2 head){
        if(head == null) return;
        //find the middle of linked list using fast-slow pointers
        ListNode2 slow = head;
        ListNode2 fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: reverse the second half
        ListNode2 sec = slow.next;
        slow.next = null;
        ListNode2 node = null;

        while(sec!=null){
            ListNode2 temp = sec.next;
            sec.next = node;
            node = sec;
            sec = temp;
        }
        // step 3: merge the lists
        ListNode2 first = head;
        sec = node;
        while(sec != null){
            ListNode2 temp1 = first.next,temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
    }
    public static void main(String [] args){

    }
}
