package 牛客网比赛;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/3/23.
 */
public class Main_profit {
    public static double money(double input,int year,double rate){
        return Math.pow(1+rate,year)*input;
    }
    public static int maxint(double p1,double p2,double p3,double p5){
        double[] sort={p1,p2,p3,p5};
        Arrays.sort(sort);
        if(sort[3]==p5) return 5;
        if(sort[3]==p3) return 3;
        if(sort[3]==p2) return 2;
        return 1;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        double r1=scan.nextDouble();
        double r2=scan.nextDouble();
        double r3=scan.nextDouble();
        double r5=scan.nextDouble();
        double[] profit=new double[n+1];
        profit[0]=1;
        profit[1]=money(profit[0],1,r1);
        profit[2]=Math.max(money(profit[0],2,r2),money(profit[1],1,r1));
        profit[3]=Math.max(Math.max(money(profit[0],3,r3),money(profit[1],2,r2)),money(profit[2],1,r1));
        profit[4]=Math.max(Math.max(money(profit[1],3,r3),money(profit[2],2,r2)),money(profit[3],1,r1));
        for(int i=5;i<=n;i++){
            profit[i]=Math.max(Math.max(Math.max(money(profit[i-5],5,r5),money(profit[i-3],3,r3)),money(profit[i-2],2,
                    r2)),money(profit[i-1],1,r1));
        }
//        for(int i=0;i<=n;i++) out.println(profit[i]);
        out.println(String.format("%.5f",profit[n]));
    }
}
