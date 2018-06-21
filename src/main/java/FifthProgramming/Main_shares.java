package FifthProgramming;

/**
 * Created by cycy on 2018/6/19.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_shares {

    public static int recur(int m,double[][] cost,int index,int remain,int len){
        if(index>=len||m==0) return remain;
        while (index<len&&cost[index][2]>0&&(int)cost[index][0]>m){
            index++;
        }
        if(index==len||cost[index][2]<=0) return remain;
        int sum=remain+((int)cost[index][1]-(int)cost[index][0])*(m/(int)cost[index][0]);
//        out.println("sum: "+sum);
        int money_remain=m%(int)cost[index][0];
        return recur(money_remain,cost,index+1,sum,len);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n ,m;
        n=scan.nextInt();
        m=scan.nextInt();
        double[][] cost = new double[n][3];
        int len=0;
        for (int i = 0; i < n&&scan.hasNext(); i++) {
            cost[i] = new double[3];
            cost[i][0] = (double) scan.nextInt();
            cost[i][1] = (double) scan.nextInt();
            cost[i][2] = (double) (cost[i][1] - cost[i][0]) / cost[i][0];
            len++;
        }
        Arrays.sort(cost, 0,len,new Comparator<double[]>() {
            public int compare(double[] o1, double[] o2) {
                if (o1[2] > o2[2]) return -1;
                else if (o1[2] < o2[2]) return 1;
                else {
                    if (o1[0] < o2[0]) return -1;
                    else return 1;
                }
            }
        });
//        for(int i=0;i<n;i++) out.println(cost[i][0]+", "+cost[i][1]+", "+cost[i][2]);
        int max = recur(m,cost,0,0,len);
        out.println(max);
    }
}