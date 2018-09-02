package ByteDance;

/**
 * Created by cycy on 2018/8/19.
 */
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {

    public static String IntArray2String(int[] nums){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<nums.length;i++)
            sb.append(nums[i]+",");
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] nums=new int[n];
        long[] sum=new long[n];
        int[][] range=new int[n][];
        nums[0]=scan.nextInt();
        sum[0]=nums[0];
        for(int i=1;i<n;i++) {
            nums[i] = scan.nextInt();
            sum[i]=sum[i-1]+nums[i];
        }

        for(int i=0;i<n;i++){
            if(range[i]==null){
                range[i]=new int[2];
                range[i][0]=i;
            }
            int j=i+1;
            for(;j<n&&nums[j]>=nums[i];j++){
                if(nums[j]==nums[i]){
                    if(range[j]==null){
                        range[j]=new int[2];
                        range[j][0]=range[i][0];
                    }
                }
            }
            if(j<n){
                if(range[j]==null){
                    range[j]=new int[2];
                    range[j][0]=range[i][0];
                }
            }
            range[i][1]=j-1;
        }

//        for(int i=0;i<n;i++)
//            out.println("min_num="+nums[i]+" , range: "+range[i][0]+","+range[i][1]);
        long max=0;
        for(int i=0;i<n;i++){
            int start=range[i][0],end=range[i][1];
            if(start!=0){
                long res=(sum[end]-sum[start-1])*nums[i];
                if(res>max) {
                    max=res;
//                    int[] tmp=new int[range[i][1]-range[i][0]+1];
//                    System.arraycopy(nums,range[i][0],tmp,0,range[i][1]-range[i][0]+1);
//                    out.println("区间："+IntArray2String(tmp)+" , min_num= "+nums[i]+" , max= "+max);
                }
            }
            else {
                long res=sum[end]*nums[i];
                if(res>max) {
                    max=res;
//                    int[] tmp=new int[range[i][1]-range[i][0]+1];
//                    System.arraycopy(nums,range[i][0],tmp,0,range[i][1]-range[i][0]+1);
//                    out.println("区间："+IntArray2String(tmp)+" , min_num= "+nums[i]+" , max= "+max);
                }
            }
        }
        out.println(max);
    }
}

