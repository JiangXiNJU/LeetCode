package 牛客网比赛.FifthProgramming;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/6/20.
 * 最近天气太热了，牛牛每天都要吃雪糕。雪糕有一盒一份、一盒两份、一盒三份这三种包装，牛牛一天可以吃多盒雪糕，但是只能吃六份，吃多了就会肚子疼，吃少了就会中暑。而且贪吃的牛牛一旦打开一盒雪糕，就一定会把它吃完。请问牛牛能健康地度过这段高温期么？
 输入描述:
 每个输入包含多个测试用例。
 输入的第一行包括一个正整数，表示数据组数T(1<=T<=100)。
 接下来N行，每行包含四个正整数，表示高温期持续的天数N(1<=N<=10000)，一盒一份包装的雪糕数量A(1<=A<=100000)，一盒两份包装的雪糕数量B(1<=B<=100000)，一盒三份包装的雪糕数量C(1<=A<=100000)。


 输出描述:
 对于每个用例，在单独的一行中输出结果。如果牛牛可以健康地度过高温期则输出"Yes"，否则输出"No"。
 */

public class Main_IceCream {

    public static boolean judge(int day,int one,int two,int thr){
        boolean can=true;
        if(one<0||two<0||thr<0||day*6>one+2*two+3*thr) return false;
        else if(day<=0||day*6<=one||day*6<=2*two||day*6<=3*thr) return true;
        return judge(day-1,one-6,two,thr)||judge(day-1,one,two-3,thr)||judge(day-1,one,two,thr-2)||judge(day-1,one-1,
                two-1,thr-1)||judge(day-1,one-2,two-2,thr)||judge(day-1,one-3,two,thr-1)||judge(day-1,one-4,two-1,thr);
    }
    public static boolean judge2(int day,int one,int two,int thr){
        day-=thr/2;
        if(day<=0) return true;
        thr=thr%2;

        day-=two/3;
        if(day<=0) return true;
        two=two%3;

        day-=one/6;
        if(day<=0) return true;
        one=one%6;
        if(thr==1){
            if(two>=1&&one>=1){
                day--;
                if(day<=0) return true;
                two--;
                one--;
            }
            else if(one>=3){
                day--;
                if(day<=0) return true;
                one-=3;
            }
        }
        if(two==1){
            if(one>=4){
                day--;
                if(day<=0) return true;
                one-=4;
            }
        }
        if(two==2){
            if(one>=2){
                day--;
                if(day<=0) return true;
                one-=2;
            }
        }
        return false;
    }
    public static boolean judge3(int day,int one,int two,int thr){
        day-=thr/2;
        if(day<=0) return true;
        thr=thr%2;
        if(thr==1){
            if(two>=1&&one>=1){
                day--;
                if(day<=0) return true;
                two--;
                one--;
            }
            else if(one>=3){
                day--;
                if(day<=0) return true;
                one-=3;
            }
        }
        day-=two/3;
        if(day<=0) return true;
        two=two%3;
        if(two==1){
            if(one>=4){
                day--;
                if(day<=0) return true;
                one-=4;
            }
        }
        if(two==2){
            if(one>=2){
                day--;
                if(day<=0) return true;
                one-=2;
            }
        }

        day-=one/6;
        if(day<=0) return true;
        one=one%6;

        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[][] records = new int[t][4];
        int len = 0;
        for (; len < t && scan.hasNext(); len++) {
            records[len] = new int[4];
            records[len][0] = scan.nextInt();
            records[len][1] = scan.nextInt();
            records[len][2] = scan.nextInt();
            records[len][3] = scan.nextInt();
        }

        for (int i = 0; i < len; i++) {
            int day = records[i][0];
            int one = records[i][1];
            int two = records[i][2];
            int thr = records[i][3];
            if(judge3(day, one, two, thr)) out.println("Yes");
            else out.println("No");
        }
    }
}