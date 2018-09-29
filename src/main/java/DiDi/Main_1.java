package DiDi;

/**
 * Created by cycy on 2018/9/18.
 */
import java.util.*;
import static java.lang.System.out;

public class Main_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n0=scan.nextInt(),n1=scan.nextInt(),n2=scan.nextInt();
        int len=n0+n1+n2;
        if(len==1) out.println(1);
        else{
            int[][][] dp=new int[len][3][4];
            if(n0>=1) {dp[0][0][0]=n0-1;dp[0][0][1]=n1;dp[0][0][2]=n2;dp[0][0][3]=1;}
            if(n1>=1) {dp[0][1][0]=n0;dp[0][1][1]=n1-1;dp[0][1][2]=n2;dp[0][1][3]=1;}
            if(n2>=1) {dp[0][2][0]=n0;dp[0][2][1]=n1;dp[0][2][2]=n2-1;dp[0][2][3]=1;}

            for(int i=1;i<len;i++){
                //0
//                if(dp)
            }
        }
        out.println();
    }
}