package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1) return head;
        ListNode real_head=head;
        int real_num=0;
        ListNode front=null;
        ListNode node=head;
        ListNode early_start=node;
        for(int i=0;i<k&&node!=null;i++){
            ListNode tmp=node.next;
            node.next=front;
            front=node;
            node=tmp;
            real_num++;
        }
//        early_start.next=front;
//        out.println("real num : "+real_num);
        if(real_num<k) {
            while(front!=null){
                ListNode tmp=front.next;
                front.next=node;
                node=front;
                front=tmp;
            }
//            early_start.next=node;
            return head;
        }
        real_head=front;
        while(true){
            real_num=0;
            front=null;
            ListNode early_start_tmp=node;
            for(int i=0;i<k&&node!=null;i++){
                ListNode tmp=node.next;
                node.next=front;
                front=node;
                node=tmp;
                real_num++;
            }
            if(real_num==k) {
                early_start.next=front;
                early_start=early_start_tmp;
            }
//            out.println("real num : "+real_num);

            if(real_num==0) break;
            if(real_num<k){
               while(front!=null){
                   ListNode tmp=front.next;
                   front.next=node;
                   node=front;
                   front=tmp;
               }
               early_start.next=node;
                break;
            }
//            ListNode n=real_head;
//            while(n!=null){
//                out.print(n.val+" ");
//                n=n.next;
//            }
//            out.println();
        }
        return real_head;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        ListNode head=new ListNode(scan.nextInt());
        int num=0;
        ListNode node=head;
        while((num=scan.nextInt())!=-1){
            node.next=new ListNode(num);
            node=node.next;
        }
        int k=scan.nextInt();

        node=new Reverse_Nodes_in_k_Group().reverseKGroup(head,k);
        while(node!=null){
            out.print(node.val+" ");
            node=node.next;
        }

    }
}
