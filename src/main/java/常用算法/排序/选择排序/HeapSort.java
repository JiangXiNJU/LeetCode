package 常用算法.排序.选择排序;

/**
 * Created by cycy on 2018/9/4.
 */
public class HeapSort {
    static int[] heap;
    static int len;
    public HeapSort(int[] nums){
        heap=nums;
        len=nums.length;
    }
    public static void swap(int a,int b){
        int tmp=heap[a];
        heap[a]=heap[b];
        heap[b]=tmp;
    }
    public static void adjustHeap(int s){
        int index=s;
        int lastpar=len/2-1;
        while(index<=lastpar){
            int left=index*2+1,right=index*2+2;
            if(left<len&&right<len){
                int ch_index=heap[left]<heap[right]?left:right;
                if(heap[index]>heap[ch_index]) {
                    swap(index, ch_index);
                    index = ch_index;
                }
                else break;
            }
            else if(left<len){
                if(heap[index]>heap[left]){
                    swap(index,left);
                    index=left;
                }
                else break;
            }
            else break;
        }
    }

    public static void makeHeap(){
        int lastpar=len/2-1;
        for(int i=lastpar;i>=0;i--){
            adjustHeap(i);
        }

    }
    public static int pop(){
        if(len==0) return Integer.MIN_VALUE;
        int res=heap[0];
        heap[0]=heap[len-1];
        len--;
        adjustHeap(0);
        return res;
    }
    public static boolean insert(int target){
        if(len==heap.length) return false;
        heap[len++]=target;
        int index=len-1;
        int par=(index-1)/2;
        while(par>=0&&heap[par]>heap[index]){
            swap(index,par);
            index=par;
        }
        return true;
    }
}
