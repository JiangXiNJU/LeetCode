package LeetCode;

/**
 *
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 Follow up:
 Can you solve it without using extra space?

 思路：
 1、前后指针 先找到环长度
 2、前后指针 找到入口
 */
public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode step1=head.next;
        ListNode step2=head.next.next;

        while(step1!=step2&&step1!=null&&step2!=null){
            step1=step1.next;
            step2=step2.next;
            if(step2!=null) step2=step2.next;
        }
        if(step1==null||step2==null) return null;

        if(step1.next==step1) return step1;

        int cycle_len=1;
        ListNode origin=step1;
        step1=step1.next;
        while(step1!=origin){
            cycle_len++;
            step1=step1.next;
        }

        step2=head;
        for(int i=0;i<cycle_len;i++)
            step2=step2.next;

        step1=head;
        while(step1!=step2){
            step1=step1.next;
            step2=step2.next;
        }
        return step1;
    }
}
