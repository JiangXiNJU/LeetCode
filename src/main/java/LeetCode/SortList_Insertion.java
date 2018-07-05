package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Sort a linked list using insertion sort.
 */
public class SortList_Insertion {
    public ListNode insertion(ListNode head,ListNode border){
        ListNode target=border.next;
        if(target==null) return head;
        if(head.val>target.val){
            border.next=target.next;
            target.next=head;
            head=target;
            return insertion(head,border);
        }
        ListNode h=head;
        while(h.next!=target&&(h.next).val<=target.val) h=h.next;
        if(h==border) return insertion(head,target);//少了这一句 死循环
        border.next=target.next;
        ListNode before=h;
        target.next=h.next;
        h.next=target;
        return insertion(head,border);
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        return insertion(head,head);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        SortList s=new SortList();

        ListNode list=new ListNode(scan.nextInt());
        ListNode node=list;
        while(scan.hasNext()) {
            int tar=scan.nextInt();
            if(tar==-1) break;
            node.next = new ListNode(tar);
            node = node.next;
        }
        out.println("Start");
        ListNode h=s.sortList(list);
        while(h!=null){
            out.print(h.val);
            h=h.next;
        }
    }
}
