package Google_kickstart.RoundD;

/**
 * Created by cycy on 2018/7/29.
 */
import java.util.*;
import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class A {
    public static void main(String[] args) {
        FileInputStream input=null;
        FileWriter fw = null;;
        try {
            input = new FileInputStream("F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\A-large.in");
            fw= new FileWriter("F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\output2");

            Scanner scan=new Scanner(input);
//            Scanner scan=new Scanner(System.in);
            /**
             * code
             */
            int t=scan.nextInt();
//            out.print("t"+t);
            for(int cases=1;cases<=t;cases++) {
                int n, o, x1, x2, a, b, c, m, l;
                long d;
                n = scan.nextInt();
                o = scan.nextInt();
                d = scan.nextLong();
                x1 = scan.nextInt();
                x2 = scan.nextInt();
                a = scan.nextInt();
                b = scan.nextInt();
                c = scan.nextInt();
                m = scan.nextInt();
                l = scan.nextInt();
//                out.println("n: "+n+" , o: "+o+" , d: "+d+" , x1: "+x1+" , x2: "+x2+" , a: "+a+" , b: "+b+" , c: " +
//                        ""+c+" , m: "+m+" , l: "+l);
                long[] x = new long[n];
                long[] s = new long[n];
                long max_value = Long.MIN_VALUE;
                x[0] = x1;
                s[0] = x[0] + l;
                x[1] = x2;
                s[1] = x[1] + l;
                for (int i = 2; i < n; i++) {
                    x[i] = (x[i - 1] * a + x[i - 2] * b + c) % m;
                    s[i] = x[i] + l;
                }

//                for(int i=0;i<n;i++)
//                    out.print(s[i]+" ");
//                out.println();
//                out.println("d: "+d+" , max_value: "+max_value);

                if (o == 0) {
                    for (int i = 0; i < n; i++) {
                        if (s[i] % 2 == 0 && s[i] <= d && s[i] > max_value) max_value = s[i];
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (s[i] <= d && s[i] > max_value) max_value = s[i];
                    }
                }
                if (max_value == Long.MIN_VALUE) {//没有任何一个可以被选
                    fw.write("Case #" + cases + ": ");
                    fw.write("IMPOSSIBLE\n");
                }
                else {
//                    int max=getmax(leftMax,d);

                }
            }
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
