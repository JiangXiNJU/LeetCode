package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static javafx.scene.input.KeyCode.Q;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 Example:

 Input: 4
 Output: [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class Solution051_N_Queens {
    boolean[] col;
    boolean[] slash_eq;
    boolean[] slash_ad;
    char[] origin;
    public List<String> get(int[] nums){
        ArrayList<String> res=new ArrayList<String>();
        int len=nums.length;
        Arrays.fill(col,false);
        Arrays.fill(slash_ad,false);
        Arrays.fill(slash_eq,false);
        for(int i=0;i<len;i++){
            int r=i,c=nums[i];
//            out.println("r: "+r+" , c: "+c);
            if(col[c]||slash_eq[len-1+r-c]||slash_ad[r+c]) return null;
            col[c]=slash_eq[len-1+r-c]=slash_ad[r+c]=true;
            origin[c]='Q';
            res.add(new String(origin));
            origin[c]='.';
        }
//        for(int i=0;i<res.size();i++)
//            out.println(res.get(i));
        return res;
    }
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res=new ArrayList<List<String>>();
        if(n==0) return res;
        if(n==1){
            List<String> res_0=new ArrayList<String>();
            res_0.add("Q");
            res.add(res_0);
            return res;
        }

        col=new boolean[n];
        slash_ad=new boolean[n*2-1];
        slash_eq=new boolean[n*2-1];
        origin=new char[n];
        Arrays.fill(origin,'.');
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

            List<String> res_0=get(nums);
            if(res_0!=null) res.add(res_0);
            num++;
        }
        out.println(num);
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int n=scan.nextInt();
        new Solution051_N_Queens().solveNQueens(n);
    }
}
