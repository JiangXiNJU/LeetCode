package ShenXinFu;

import java.util.Scanner;

import static java.lang.System.out;

/**
 *
 */

public class Main_5 {
    public static int find(int[] nums,int target){
        for(int i=1;i<=target;i++){
            if(nums[i]==target) return i;
        }
        return 0;
    }
    public static void roate(int [] nums,int start,int end){
        int tmp=0;
        for(int i=start;i<=(start+end)/2;i++){
            tmp=nums[i];
            nums[i]=nums[end+start-i];
            nums[end+start-i]=tmp;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        out.println();
        int n=scan.nextInt();
        int [] nums=new int[n+1];
        for(int i=1;i<=n;i++)
            nums[i]=scan.nextInt();
        int time=0;
        int target=n;
        while(target>=1){
            int index=find(nums,target);
            if(index!=target){
                roate(nums,index,target);
                time++;
            }

            target--;
        }
        out.println(time);
    }
}