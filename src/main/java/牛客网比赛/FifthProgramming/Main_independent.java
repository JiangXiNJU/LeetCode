package 牛客网比赛.FifthProgramming;

/**
 * Created by cycy on 2018/6/20.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_independent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x, f, d, p;
        x = scan.nextInt();
        f = scan.nextInt();
        d = scan.nextInt();
        p = scan.nextInt();
        int day = 0;
        if (d / x <= f) day = d / x;
        else day = f + (d - f * x) / (x + p);
        out.println(day);
    }
}