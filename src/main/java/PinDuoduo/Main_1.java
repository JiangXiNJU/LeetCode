package PinDuoduo;

/**
 * 最长山谷
 * A 的最长连续子数组 B 满足条件
 * B长大于等于3
 *
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static int method(int[] A,int len){
        if(len<3) return 0;

        int max=0;
        int front=0,back=0;
        for(int i=1;i<len-1;i++){
            if(A[i]<A[i-1]) front++;
            if(A[i]<A[i+1]) back++;
            if(A[i]>=A[i-1]&&A[i]>=A[i+1]){
                if(front>0&&back>0&&front+back+1>max) max=front+back+1;
                front=back=0;
            }
        }
        if(front>0&&back>0&&front+back+1>max) max=front+back+1;
        return max;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A=new int[10005];
        int len=0;
        while(scan.hasNextInt()){
            A[len++]=scan.nextInt();
        }
//        int [] A={4,3,2,5,3,1,4,8};
//        int[] A={1,0,3};
//        int len=A.length;
        int res=method(A,len);
        out.println(res);
    }
}