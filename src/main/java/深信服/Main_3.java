package 深信服;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/**
 *
 */

public class Main_3 {
    public static boolean recur(int[] score,int index,int n,int sum,ArrayList res){
//        out.print(index+", "+sum+":  ");
//        for(int i=0;i<res.size();i++)
//            out.print(res.get(i)+" ");
//        out.println();
        if(index>=n) {
//            if(res.size()>0) res.remove(res.size()-1);
            return false;
        }
        if(score[index]==sum) {
            res.add(index);
            return true;
        }
        if(score[index]<sum){
            res.add(index);
            if(recur(score,index+1,n,sum-score[index],res))
                return true;
            else{
                if(res.size()>0) res.remove(res.size()-1);
                return recur(score,index+1,n,sum,res);
            }
        }
        else return recur(score,index+1,n,sum,res);

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=scan.nextInt();
        int[] score=new int[n];
        for(int i=0;i<n;i++)
            score[i]=scan.nextInt();
        ArrayList res=new ArrayList();
        recur(score,0,n,100,res);
        int len=res.size();
        out.println(len);
        for(int i=0;i<len;i++)
            out.println(((Integer)res.get(i)+1));
    }
}