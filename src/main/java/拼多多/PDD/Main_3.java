package 拼多多.PDD;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        HashMap<Integer, Integer> mp = new HashMap<Integer,Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append(a/b);
        int mod = a%b;
        if (mod == 0) {
            System.out.println(0 + " " + 0); // first 0 should be #digits of a/b?
            return;
        }
        // stringBuilder.append(".");
        // int pre_length = stringBuilder.length();
        mod *= 10;
        int start_p = -1, length = -1;
        while (mod != 0) {
            int div = mod / b;
            if (mp.containsKey(mod)) {
                start_p = mp.get(mod);
                length = stringBuilder.length()-start_p;
                break;
            }
            mp.put(mod, stringBuilder.length());
            stringBuilder.append(div);
            mod = (mod % b) * 10;
        }
        if (start_p == -1) {
            start_p = stringBuilder.length();
            length = 0;
        }
        out.println(start_p + " " + length);
        // System.out.println((double)a / b);
    }
}

