package 剑指OFFER;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/18.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution_EntryNodeOfLoop {
    public boolean InLoop(ListNode head,ListNode p){
        ListNode c=head;
        while(c!=null){
            if(c==p) return false;
            if(c==p.next) return true;
            c=c.next;
        }
        return false;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode p=pHead;
        while(p!=null){
            if(p.next==p) return p;
            if(InLoop(pHead,p)==true) return p.next;
            p=p.next;
        }
        return p;
    }
    public ListNode buildList(int[] array1,int [] array2){
        ListNode pHead=null;
        ListNode pLoop=null;

            pLoop=new ListNode(array2[0]);
            int index=1;
            ListNode p=pLoop;
            while(index<array2.length){
                p.next=new ListNode(array2[index]);
                p=p.next;
                index++;
            }
            p.next=pLoop;
        if(array1.length==0) return pLoop;
        else {
            pHead=new ListNode(array1[0]);
            index=1;
            p=pHead;
            while(index<array1.length){
                p.next=new ListNode(array1[index]);
                p=p.next;
                index++;
            }
            p.next=pLoop;
        }
        return pHead;
    }
    public static void main(String[] args){
        Solution_EntryNodeOfLoop s=new Solution_EntryNodeOfLoop();
        int[] array1={1,2};
        int[] array2={3,4,5};
        ListNode pHead=s.buildList(array1,array2);
        ListNode p=pHead;
        out.println("end build");
//        while(p!=null){
//            out.println(p.val);
//            p=p.next;
//        }
        ListNode res=s.EntryNodeOfLoop(pHead);
        out.println(res.val);
    }
}
