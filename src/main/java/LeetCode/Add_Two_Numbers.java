package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/7/5.
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode tail=new ListNode((l1.val+l2.val)%10);
        ListNode sum=tail;
        int cnt=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null&&l2!=null){
            int a=l1.val,b=l2.val;
            sum.next=new ListNode((a+b+cnt)%10);
            cnt=(a+b+cnt)/10;
            sum=sum.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null&&l2!=null) {
            while (cnt > 0 && l2 != null) {
                sum.next = new ListNode((l2.val + cnt) % 10);
                sum = sum.next;
                cnt = (l2.val + cnt) / 10;
                l2 = l2.next;
            }
            if (l2 != null) sum.next = l2;
            else if (cnt > 0) sum.next = new ListNode(cnt);
        }
        else if(l1!=null&&l2==null) {
            while (cnt > 0 && l1 != null) {
                sum.next = new ListNode((l1.val + cnt) % 10);
                sum = sum.next;
                cnt = (l1.val + cnt) / 10;
                l1 = l1.next;
            }
            if (l1 != null) sum.next = l1;
            else if (cnt > 0) sum.next = new ListNode(cnt);
        }
        else {
            if(cnt>0) sum.next=new ListNode(cnt);
        }
        return tail;
    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Add_Two_Numbers s=new Add_Two_Numbers();

        ListNode list1=new ListNode(scan.nextInt());
        ListNode node1=list1;
        while(scan.hasNext()) {
            int tar=scan.nextInt();
            if(tar==-1) break;
            node1.next = new ListNode(tar);
            node1 = node1.next;
        }

        ListNode list2=new ListNode(scan.nextInt());
        ListNode node2=list2;
        while(scan.hasNext()) {
            int tar=scan.nextInt();
            if(tar==-1) break;
            node2.next = new ListNode(tar);
            node2 = node2.next;
        }

        out.println("Start");
        ListNode h=s.addTwoNumbers(list1,list2);
        while(h!=null){
            out.print(h.val);
            h=h.next;
        }
    }
}
