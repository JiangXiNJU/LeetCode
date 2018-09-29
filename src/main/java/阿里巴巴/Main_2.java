package 阿里巴巴;

/**
 * Created by cycy on 2018/9/7.
 */
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static boolean canwin(int[] nums){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=nums.length;
        int len=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0) len++;
            if(nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
        }

        if(len==1) return false;
        if(len==2){
            if(max==1) return true;
            else return false;
        }
        if(max==1){
            if(n%2==1) return false;
            return true;
        }

        return false;
    }
    public static int get(int[] nums){
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                nums[i]=0;
                if(canwin(nums)) ans++;
                nums[i]=1;
            }
            else{
                int origin=nums[i];
                nums[i]=0;
                if(canwin(nums)) ans++;
                nums[i]=1;
                if(canwin(nums)) ans++;
                nums[i]=origin;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str0=scan.nextLine();
        int len=str0.length();
        String str1=str0.substring(1).substring(0,len-2);
        String[] tokens=str1.split(",");
        int[] nums=new int[tokens.length];
        int n=tokens.length;
        for(int i=0;i<n;i++)
            nums[i]=Integer.parseInt(tokens[i]);
        Arrays.sort(nums);
        int res=get(nums);
        out.println(res);
    }
}

