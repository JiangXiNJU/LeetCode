package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode[] partition(ListNode head,ListNode tail,ListNode head_front,ListNode tail_after){
        ListNode[] tmp=new ListNode[4];
        tmp[0]=tmp[1]=head;
        tmp[2]=tmp[3]=tail;

//        out.print("Partition: ");
//        ListNode tmp_h=head;
//        while(tmp_h!=tail_after){
//            out.print(tmp_h.val+" ");
//            tmp_h=tmp_h.next;
//        }
//        out.println("end");

        if(head==tail) return tmp;

        int target=tail.val;
        if(head.val>=target){
            ListNode origin_head=head;
            while(head.next!=tail&&(head.next).val>=target) head=head.next;
            ListNode new_head=head.next;
            if(head_front!=null) head_front.next=new_head;
            tail.next=origin_head;
            head.next=tail_after;
            tmp[0]=tmp[1]=new_head;
        }

        ListNode n=tmp[0];
        while(n!=tail){
            ListNode n_before=n;
            while(n.next!=tail&&(n.next).val>=target) n=n.next;
            if(n==n_before) n=n.next;
            else{
                ListNode new_head=n.next;
                ListNode new_n_head=n_before.next;
                n_before.next=new_head;
                n.next=tail.next;
                tail.next=new_n_head;
                n=new_head;
            }
        }

        n=tmp[0];
        while(n!=tail_after){
            if(n.next==tail) tmp[1]=n;
            if(n==tail) tmp[2]=tail.next;
            if(n.next==tail_after){
                if(n==tail) tmp[3]=tmp[2];
                else tmp[3]=n;
            }
            n=n.next;
        }
//        out.print("tmp: ");
//        for(int i=0;i<4;i++) {
//            if(tmp[i]!=null)
//                out.print(tmp[i].val+" ");
//            else out.print("null ");
//        }
//        out.println();
        return tmp;
    }
    public ListNode quicksort(ListNode head,ListNode tail,ListNode head_front,ListNode tail_after){
        if(head==tail) return head;
        ListNode[] tmp=partition(head,tail,head_front,tail_after);
//        out.print("tmp: ");
//        for(int i=0;i<4;i++) {
//            if(tmp[i]!=null)
//                out.print(tmp[i].val+" ");
//            else out.print("null ");
//        }
//        out.println();
        ListNode final_head=tmp[0];
        if(tmp[0]!=null&&tmp[1]!=null) final_head=quicksort(tmp[0],tmp[1],head_front,tail);
        if(tmp[2]!=null&&tmp[3]!=null) quicksort(tmp[2],tmp[3],tail,tail_after);
        return final_head;
    }
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ListNode tail=head;
        while(tail.next!=null) tail=tail.next;
        ListNode final_head=quicksort(head,tail,null,null);
        return final_head;
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
