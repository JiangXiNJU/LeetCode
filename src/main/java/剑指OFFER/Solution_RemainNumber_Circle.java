package 剑指OFFER; /**
 * Created by cycy on 2018/5/18.
 */

import Util.Print;

import static java.lang.System.out;

public class Solution_RemainNumber_Circle {
    public int LastRemaining_Solution(int n, int m) {
        if(n==1) return 0;
        int[] record=new int[n];
        int pos=0;
        for(int i=0;i<n;i++){
            pos=(pos-1+m)%(n-i);
            if(pos+1<n-i){
                if(record[pos+1]==0) record[pos]=
                record[pos]=record[pos]+1;
            }

            out.print(i+": ");
            Print.Print_Array(record,0,n-1);
        }
        Print.Print_Array(record,0,n-1);
        for(int i=n-2;i>=0;i--){
            int remote_pos=record[i]+i;
            if(record[remote_pos]==0) record[i]=remote_pos;
            else record[i]=record[remote_pos];
        }
        Print.Print_Array(record,0,n-1);
        out.println(record[0]);
        return record[0];
    }
    public static void main(String[] args){
        int n=5;
        int m=2;
        Solution_RemainNumber_Circle s=new Solution_RemainNumber_Circle();
        s.LastRemaining_Solution(n,m);
    }
}
