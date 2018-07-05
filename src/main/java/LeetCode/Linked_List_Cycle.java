package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a linked list, determine if it has a cycle in it.
 Follow up:
 Can you solve it without using extra space?
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(head.next==null) return false;
        ListNode step1=head.next;
        ListNode step2=head.next.next;
        //初始化一定要分开，否则无法进入循环
        while(step2!=null&&step2.next!=null&&step2!=step1){
//            if(step2!=null) out.println("step2 : "+step2.val);
//            if(step1!=null) out.println("step1 : "+step1.val);
            step2=(step2.next).next;
            step1=step1.next;
        }
//        if(step1==step2) out.println("same");
        if(step1==step2&&step1!=null) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Linked_List_Cycle s=new Linked_List_Cycle();

        ListNode list=new ListNode(scan.nextInt());
        ListNode node=list;
        while(scan.hasNext()) {
            int tar=scan.nextInt();
            if(tar==-1) break;
            node.next = new ListNode(tar);
            node = node.next;
        }
        out.println("Start");
        out.println(s.hasCycle(list));
    }
}
