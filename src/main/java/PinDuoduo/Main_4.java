package PinDuoduo;

/**
 * Created by cycy on 2018/7/22.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_4 {
    public static boolean diff(int a,int b,int target){
        if(Math.abs(a-b)<=target) return true;
        return false;
    }
    public static boolean abso(int a,int b,int target){
        if(Math.abs(a-b)==target) return true;
        return false;
    }
    public static int method(int[] nums,int n,int k){
        int[][] time=new int[10][2];
        int[][] time_origin=new int[10][2];
        for(int i=0;i<10;i++){
            time[i]=new int[2];
            time[i][0]=i;
            time_origin[i]=new int[2];
            time_origin[i][0]=i;
        }
        for(int i=0;i<n;i++)
            time[nums[i]][1]++;
        for(int i=0;i<10;i++){
            if(time[i][1]>=k) return 0;
            time_origin[i][1]=time[i][1];
        }
        Arrays.sort(time, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]) return 1;
                else return -1;
            }
        });

        int min=k*9;
        int target=0;
        ArrayList<int[]> res_data=new ArrayList<int[]>();
        while(target<10){
            int target_num=time[target][0];
            int sum=0;
            int remain=k-Math.min(time[target][1],k);
            int diff=0;
            while(remain>0&&sum>=min){
                diff++;
//                out.println("target_num: "+target_num+" , diff: "+diff);
                if(target_num-diff<0){
                    sum+=diff*Math.min(time_origin[target_num+diff][1],remain);
                    remain-=Math.min(time_origin[target_num+diff][1],remain);
                }
                else if(target_num+diff>9){
                    sum+=diff*Math.min(time_origin[target_num-diff][1],remain);
                    remain-=Math.min(time_origin[target_num-diff][1],remain);
                }
                else{
                    sum+=diff*Math.min(time_origin[target_num+diff][1]+time_origin[target_num-diff][1],remain);
                    remain-=Math.min(time_origin[target_num+diff][1]+time_origin[target_num-diff][1],remain);
                }
            }
//            out.println("target_num: "+target_num+" , diff: "+diff+" , sum: "+sum);
            if(sum<=min){
                if(sum==min){
                    int[] tmp={sum,target_num,diff};
                    res_data.add(tmp);
                }
                else{
                    int[] tmp={sum,target_num,diff};
                    res_data=new ArrayList<int[]>();
                    res_data.add(tmp);
                    min=sum;
                }
            }
            target++;
        }
        min=res_data.get(0)[0];
        int[][] res_nums=new int[res_data.size()][n];
        for(int i=0;i<res_data.size();i++){
            res_nums[i]=new int[n];
            int target_num=res_data.get(i)[1];
            int diff=res_data.get(i)[2];
            int remain=k;
            for(int j=0;j<n;j++){
                if(diff(nums[j],target_num,diff-1)) {
                    res_nums[i][j]=target_num;
                    remain--;
                }
                else res_nums[i][j]=nums[j];
            }
            for(int j=n-1;j>=0&&remain>0;j--){
                if(res_nums[i][j]!=target_num&&abso(res_nums[i][j],target_num,diff)) {
                    res_nums[i][j]=target_num;
                    remain--;
                }
            }
        }
        Arrays.sort(res_nums, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int len=o1.length;
                for(int i=0;i<len;i++){
                    if(o1[i]<o2[i]) return -1;
                    else if(o1[i]>o2[i]) return 1;
                }
                return -1;
            }
        });
        for(int i=0;i<n;i++){
            nums[i]=res_nums[0][i];
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),k=scan.nextInt();
        int[] nums=new int[n];
        scan.nextLine();
        String ss=scan.nextLine();
        for(int i=0;i<n;i++)
            nums[i]=ss.charAt(i)-'0';
        int money=method(nums,n,k);
        out.println(money);
        for(int i=0;i<n;i++)
            out.print(nums[i]);
        out.println();
    }
}
