package IQIYI;

/**
 * Created by cycy on 2018/9/28.
 */
import java.util.*;
import static java.lang.System.out;

public class Main_2 {

    public static long result(int n){
        long ans=0;
        //从2个开
        long[] prev_sum=new long[2];

        prev_sum[0]=1;//选了
        prev_sum[1]=1;//没选
        for(int i=1;i<n;i++){
            long[] now_sum=new long[2];
            now_sum[0]=prev_sum[1];
            now_sum[1]=prev_sum[0]+prev_sum[1];
            prev_sum=now_sum;
//            out.println(i+": "+now_sum[0]+" , "+now_sum[1]);
        }
        ans=prev_sum[0]+prev_sum[1];
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        out.println(result(n));
    }
}
