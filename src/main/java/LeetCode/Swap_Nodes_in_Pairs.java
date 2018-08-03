package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Note:

 Your algorithm should use only constant extra space.
 You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode res=head.next;
        ListNode tmp=head.next;
        head.next=tmp.next;
        tmp.next=head;
        ListNode front=head;
        while(front.next!=null&&front.next.next!=null){
            ListNode f=front.next,b=front.next.next;
            front.next=b;
            f.next=b.next;
            b.next=f;
            front=f;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

    }
}
