package 科大讯飞;

/**
 * Created by cycy on 2018/9/7.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    static class Node{
        int val;
        Node next=null;
        Node prev=null;
        Node(int _val,Node _p){
            val=_val;
            prev=_p;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        Node head=new Node(scan.nextInt(),null);
        Node prev=head;
        Node tail=head;
        for(int i=1;i<n;i++){
            Node node=new Node(scan.nextInt(),prev);
            prev.next=node;
            prev=node;
            if(i==n-1) tail=node;
        }
        int day=0;
        int size=n;
        boolean continued=true;
        while(continued){
            if(size<=1) break;
            continued=false;
            while(tail!=head){
                if(tail.prev.val>tail.val){
                    tail=tail.prev;
                    tail.next=null;
                    continued=true;
                    size--;
                }
                else break;
            }

            Node tmp=tail.prev;
            while(tmp!=head&&tmp!=null){
                if(tmp.prev.val>tmp.val){
                    continued=true;
                    tmp.prev.next=tmp.next;
                    tmp=tmp.prev;
                    size--;
                }
                else tmp=tmp.prev;
            }

            if(continued) day++;
        }
        out.println(day);
    }
}

/**
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Scanner;

 import static java.lang.System.out;

 public class Main {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int n=scan.nextInt();
 LinkedList<Integer> list=new LinkedList<Integer>();
 for(int i=0;i<n;i++)
 list.add(scan.nextInt());
 int size=list.size();
 int day=0;
 boolean continued=true;
 while(continued){
 if(list.size()<=1) break;
 int index=list.size()-1;
 continued=false;
 while(index>0){
 if(list.get(index)<list.get(index-1)){
 continued=true;
 list.remove(index);
 }
 index--;
 }
 if(continued) day++;
 }
 out.println(day);
 }
 }

 */