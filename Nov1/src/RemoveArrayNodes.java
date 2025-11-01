import java.util.HashSet;
import java.util.Set;

class ListNode{
    ListNode next;
    int val;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class LinkedListOps{

    public ListNode insertAtBegin(ListNode head,int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }

    public void displayList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public ListNode insertAtEnd(ListNode head,int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            insertAtBegin(head,val);
            return newNode;
        }
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

    public ListNode removeArrayNodes(int [] arr,ListNode head){
        Set<Integer> set = new HashSet<>(); // set is used to reduce lookup - O(1)
        for(int x : arr){
            set.add(x);
        }
        while(head  != null && set.contains(head.val)){
            head = head.next;
        }
        ListNode temp = head;
        while(temp != null && temp.next != null){
            while(temp.next!=null && set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            temp =temp.next;
        }
        return head;
    }

}

public class RemoveArrayNodes {
    public static void main(String [] args){

        ListNode head = null;
        LinkedListOps ops = new LinkedListOps();
//        head = ops.insertAtBegin(head,10);
        head = ops.insertAtEnd(head,10);
        head = ops.insertAtEnd(head,20);
        head = ops.insertAtEnd(head,30);
        head = ops.insertAtEnd(head,40);
        head = ops.insertAtEnd(head,50);
        ops.displayList(head);
        int [] arr = {10,20,30};
        head = ops.removeArrayNodes(arr,head);
        ops.displayList(head);

    }
}
