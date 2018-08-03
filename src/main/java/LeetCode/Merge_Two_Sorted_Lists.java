package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return l1;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=l1.val<=l2.val?l1:l2;
        ListNode n1=l1,n2=l2,n=head;
        if(l1.val<=l2.val) n1=n1.next;
        else n2=n2.next;
        while(n1!=null&&n2!=null){
            if(n1.val<=n2.val){
                n.next=n1;
                n1=n1.next;
                n=n.next;
            }
            else{
                n.next=n2;
                n2=n2.next;
                n=n.next;
            }
        }
        if(n1==null) n.next=n2;
        else if(n2==null) n.next=n1;
        return head;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

    }
}
