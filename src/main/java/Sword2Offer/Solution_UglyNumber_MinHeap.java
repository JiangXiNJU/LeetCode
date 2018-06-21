package Sword2Offer;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/14.
 */
class Node{
    int fac;
    long val;
    public Node(int _f,long _val){
        fac=_f;
        val=_val;
    }
}
public class Solution_UglyNumber_MinHeap {
    public void swap(Node[] array,int a,int b){
        Node tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
    }
    public Node[] buildMinHeap(Node[] array,int lenofarray){
        int pos=lenofarray-1;
        while(pos>=0){
            int parent_pos=(pos-1)/2;
            if(array[parent_pos].val>array[pos].val)
                swap(array,pos,parent_pos);
            while(parent_pos*2+1<lenofarray){
                int child1_pos=parent_pos*2+1;
                int child2_pos=parent_pos*2+2;
                if(child2_pos<lenofarray){
                    if(array[child1_pos].val<array[parent_pos].val){
                        swap(array,child1_pos,parent_pos);
                        parent_pos=child1_pos;
                    }
                    else if(array[child2_pos].val<array[parent_pos].val){
                        swap(array,child2_pos,parent_pos);
                        parent_pos=child2_pos;
                    }
                    else break;
                }
                else{
                    if(array[child1_pos].val<array[parent_pos].val){
                        swap(array,child1_pos,parent_pos);
                        parent_pos=child1_pos;
                    }
                    break;
                }
            }
            pos--;
        }
        return array;
    }
    public void insertMinHeap(Node input,Node[] array,int lenofarray){
        array[lenofarray]=input;
        int pos=lenofarray;
        int parent_pos=(pos-1)/2;
        while(parent_pos>=0){
            if(array[parent_pos].val>array[pos].val){
                swap(array,pos,parent_pos);
                pos=parent_pos;
                parent_pos=(pos-1)/2;
            }
            else break;
        }
    }

    public Node outputMinHeap(Node[] array,int lenofarray){
        if(lenofarray==0) return null;
        Node res=array[0];
        swap(array,lenofarray-1,0);
        lenofarray--;
        int pos=0;
        while(pos*2+1<lenofarray){
            int child1_pos=pos*2+1;
            int child2_pos=pos*2+2;
            if(child2_pos<lenofarray) {
                int child = array[child1_pos].val>array[child2_pos].val?child2_pos:child1_pos;
                if (array[pos].val > array[child].val) {
                    swap(array, pos, child);
                    pos = child;
                }
                else break;
            }
            else{
                if (array[pos].val > array[child1_pos].val) {
                    swap(array, pos, child1_pos);
                    pos = child1_pos;
                }
                else break;
            }
        }
        return res;
    }
    public long getproduct(long a,long b){
        if(a*b<0) return Long.MAX_VALUE;
        return a*b;
    }
    public int GetUglyNumber_Solution(int index) {
        if(index<=1) return index;
        Node[] record=new Node[index*3+3];
        record[0]=new Node(2,1);
        int num=0;
        int len=1;
        Node res=record[0];
        while(num<index){
            Node curmin=record[0];
            if(curmin.fac==2){
                insertMinHeap(new Node(2,getproduct(curmin.val,2)),record,len);
                len++;
                insertMinHeap(new Node(3,getproduct(curmin.val,3)),record,len);
                len++;
                insertMinHeap(new Node(5,getproduct(curmin.val,5)),record,len);
                len++;
            }
            else if(curmin.fac==3){
                insertMinHeap(new Node(3,getproduct(curmin.val,3)),record,len);
                len++;
                insertMinHeap(new Node(5,getproduct(curmin.val,5)),record,len);
                len++;
            }
            else{
                insertMinHeap(new Node(5,getproduct(curmin.val,5)),record,len);
                len++;
            }
            res=outputMinHeap(record,len);
//            out.print(res.val+" ");
            len--;
            num++;
        }
        return (int)res.val;
    }
    public static void main(String[] args){
        Solution_UglyNumber_MinHeap s=new Solution_UglyNumber_MinHeap();
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int index=scan.nextInt();
            out.println(s.GetUglyNumber_Solution(index));
        }

    }
}
