package 字节跳动.BigData2018_4;

/**
 * Created by cycy on 2018/8/24.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] room=new int[n];
        for(int i=0;i<n;i++)
            room[i]=scan.nextInt()-1;
        int[] time=new int[n];
        time[0]=1;
        int step=0,index=room[0];
        while(time[n-1]<2){
            time[index]=time[index]+1;
            step=(step%1000000007+1)%1000000007;
            index=time[index]%2==0?index+1:room[index];
        }
        step++;
        out.println(step);
    }
}
