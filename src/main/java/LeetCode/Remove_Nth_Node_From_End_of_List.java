package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:

 Could you do this in one pass?
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode step1=head;
        ListNode step2=head;
        if(n==1&&head.next==null) return null;
        for(int i=0;i<n;i++)
            step1=step1.next;
        if(step1==null) return head.next;
        while(step1.next!=null){
            step1=step1.next;
            step2=step2.next;
        }
        step2.next=step2.next.next;
        return head;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

    }
}
