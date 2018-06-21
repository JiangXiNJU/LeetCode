package ShenXinFu;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/**
 *
 */

public class Main_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println();
        String[] array = {"3334", "3", "333332"};
        int[] ids=new int[1005];
        for(int i=0;i<1005;i++)
            ids[i]=0;
        int n=scan.nextInt();
        int num=0;
        ArrayList res=new ArrayList();
        for(int i=0;i<n&&num<10;i++){
            int id=scan.nextInt();
            if(ids[id]==0){
                ids[id]++;
                res.add(id);
                num++;
            }
        }
        out.println(num);
        for(int i=0;i<num;i++)
            out.println(res.get(i));
    }
}