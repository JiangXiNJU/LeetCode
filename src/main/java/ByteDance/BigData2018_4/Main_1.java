package ByteDance.BigData2018_4;

/**
 * Created by cycy on 2018/8/24.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        for(int T=0;T<t;T++){
            long n=scan.nextLong(),k=scan.nextLong(),d1=scan.nextLong(),d2=scan.nextLong();
            long c3=0,c2=0,c1=0;
            long ave=n/3;

            if(n%3!=0) out.println("no");
            else {
                boolean find = false;

                if ((k - d1 - d2) % 3 == 0) {
                    c2 = (k - d1 - d2) / 3;
                    c1 = c2 + d1;
                    c3 = c2 + d2;
                    if (c2 >= 0 && c1 <= ave && c3 <= ave) find = true;
                }

                if (!find && (k - 2 * d2 - d1) % 3 == 0) {
                    c3 = (k - 2 * d2 - d1) / 3;
                    c2 = c3 + d2;
                    c1 = c2 + d1;
                    if (c3 >= 0 && c2 <= ave && c1 <= ave) find=true;
                }

                if(!find&&(k-2*d1-d2)%3==0){
                    c1=(k-2*d1-d2)/3;
                    c2=c1+d1;
                    c3=c2+d2;
                    if(c1>=0&&c2<=ave&&c3<=ave) find=true;
                }

                if(!find&&(k+d1+d2)%3==0){
                    c2=(k+d1+d2)/3;
                    c1=c2-d1;
                    c3=c2-d2;
                    if(c2<=ave&&c1>=0&&c3>=0) find=true;
                }

                if (find) out.println("yes");
                else out.println("no");
            }
        }
    }
}
