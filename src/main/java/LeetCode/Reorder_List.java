package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||(head.next).next==null) return;
        ListNode step1=head;
        ListNode step2=head;
        while(step2.next!=null&&(step2.next).next!=null){
            step1=step1.next;
            step2=(step2.next).next;
        }

        ListNode line1=head;
        ListNode line2=step2.next==null?step2:step2.next;

        step2=step1.next.next;
        step1.next.next=null;
        ListNode lastNode=step1.next;
        while(step2!=null){
            ListNode tmp=step2.next;
            step2.next=lastNode;
            lastNode=step2;
            step2=tmp;
        }

        ListNode next_1=line1;
        ListNode next_2=line2;
        while(line1!=null&&line2!=null){
            next_1=line1.next;
            next_2=line2.next;
            line1.next=line2;
            line2.next=next_1;
            line1=next_1;
            line2=next_2;
        }
        if(line1!=null) line1.next=null;
        if(line2!=null) line1.next=line2;

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Reorder_List r=new Reorder_List();

        ListNode list=new ListNode(scan.nextInt());
        ListNode node=list;
        while(scan.hasNext()) {
            int tar=scan.nextInt();
            if(tar==-1) break;
            node.next = new ListNode(tar);
            node = node.next;
        }
        out.println("Start");
        r.reorderList(list);
        while(list!=null){
            out.print(list.val);
            list=list.next;
        }
    }
}
