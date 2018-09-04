package LeetCode.全排列;

import Util.Print;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/9/3.
 */
public class Solution031_Next_Permutation {
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public void reverse(int[] nums,int f,int b){
        while(f < b){
            swap(nums, f, b);
            f++;
            b--;
        }
    }
    public int find_LittleBigger(int[] nums,int f,int b,int target){
        if(nums[f]<=target) return -1;
        if(nums[b]>target) return b;
        while(f<=b){
            int mid=f+(b-f)/2;
            if(nums[mid]<=target) b=mid-1;
            else f=mid+1;
        }
        return f-1;
    }
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2) return;
        int index_f=nums.length-2;
        while (index_f>=0&&nums[index_f]>=nums[index_f+1]) index_f--;

        if(index_f>=0){
            int index_b=nums.length-1;
            while(index_b>index_f&&nums[index_b]<=nums[index_f]) index_b--;
//        out.println("index_f,index_b: "+index_f+","+index_b);
            swap(nums,index_f,index_b);
        }

        reverse(nums,index_f+1,nums.length-1);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scan.nextInt();
        Solution031_Next_Permutation s=new Solution031_Next_Permutation();
        s.nextPermutation(nums);
        Print.Print_IntArray(nums,0,nums.length-1);
    }
}
