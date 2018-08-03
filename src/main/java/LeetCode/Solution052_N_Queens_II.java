package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class Solution052_N_Queens_II {
    boolean[] col;
    boolean[] slash_eq;
    boolean[] slash_ad;
    public boolean get(int[] nums){
        ArrayList<String> res=new ArrayList<String>();
        int len=nums.length;
        Arrays.fill(col,false);
        Arrays.fill(slash_ad,false);
        Arrays.fill(slash_eq,false);
        for(int i=0;i<len;i++){
            int r=i,c=nums[i];
//            out.println("r: "+r+" , c: "+c);
            if(col[c]||slash_eq[len-1+r-c]||slash_ad[r+c]) return false;
            col[c]=slash_eq[len-1+r-c]=slash_ad[r+c]=true;
        }
//        for(int i=0;i<res.size();i++)
//            out.println(res.get(i));
        return true;
    }
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public  int totalNQueens(int n) {
        if(n==1) return 1;
        if(n<4) return 0;

        col=new boolean[n];
        slash_ad=new boolean[n*2-1];
        slash_eq=new boolean[n*2-1];

        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i;

        boolean flag=true;
        int num=0;
        while (flag){
            int index=nums.length-1;
            while(index>0&&nums[index-1]>nums[index]) index--;
            if(index==0) break;
            index--;
            int index_end=nums.length-1;
            while(index_end>index&&nums[index_end]<nums[index]) index_end--;
            swap(nums,index,index_end);

            Arrays.sort(nums,index+1,nums.length);
//            int f=index+1;
//            int b = nums.length-1;
//                for (int i = 0; i < (b - f + 1) / 2; i++)
//                    swap(nums, f + i, b - i);

            if(get(nums)) num++;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int n=scan.nextInt();
        new Solution051_N_Queens().solveNQueens(n);
    }
}
