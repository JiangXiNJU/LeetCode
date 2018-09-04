package LeetCode.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 无重复，直接把所有可能的值排列即可
 */
public class Solution046_Permutations {
    public ArrayList<Integer> fill(int[] nums){
        ArrayList<Integer> res=new ArrayList<Integer>(nums.length);
        for(Integer i:nums)
            res.add(i);
        return res;
    }
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public void recur(int[] nums,int start,List<List<Integer>> res){
        if(start==nums.length-1) res.add(fill(nums));
        else{
            for(int j=start;j<nums.length;j++){
                swap(nums,j,start);
                recur(nums,start+1,res);
                swap(nums,j,start);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return res;
        recur(nums,0,res);
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int n=scan.nextInt();
        int [] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=scan.nextInt();
        List<List<Integer>> res=new Solution046_Permutations().permute(num);
//        for(int i=0;i<res.size();i++){
//            for(int j=0;j<n;j++){
//                out.print(res.get(i).get(j));
//            }
//            out.println();
//        }
    }
}
