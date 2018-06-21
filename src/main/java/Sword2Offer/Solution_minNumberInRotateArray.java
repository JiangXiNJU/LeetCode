package Sword2Offer;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/4/3.
 */
public class Solution_minNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int head=array[0];
        int tail=array[array.length-1];
        int f=0,b=array.length;
        if(head<tail) return head;
        if(head==tail){
            int index=1;
            while(index<b&&array[index]==head){
                index++;
            }
            if(index==b) return head;
            if(array[index]<tail) return array[index];
            head=array[index];
            f=index;
        }
        while(b>f+1){
            int mid=(f+b)/2;
            if(array[mid]>=head) f=mid;
            else if(array[mid]<=tail) b=mid;
        }
        if(b<array.length) return Math.min(array[f],array[b]);
        else return array[f];
    }

    public static void main(String[] args){
        int[] array={3,3,0,3,3};
        Solution_minNumberInRotateArray tmp=new Solution_minNumberInRotateArray();
        out.println(tmp.minNumberInRotateArray(array));
    }
}
