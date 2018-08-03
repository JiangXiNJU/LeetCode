package LeetCode;

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

 */
public class Solution046_Permutations {
    public boolean judge_modify(int[] nums){
        if(nums.length==1) return false;
        int index=nums.length-1;
        while(index>=1&&nums[index]<nums[index-1]) index--;
        if(index==0) return false;

        index--;
        int index_2=nums.length-1;
        while(index_2>index&&nums[index_2]<nums[index]) index_2--;
        int tmp=nums[index_2];
        nums[index_2]=nums[index];
        nums[index]=tmp;
        Arrays.sort(nums,index+1,nums.length);
        return true;
    }
    public void com(int[] nums,ArrayList<List<Integer>> res){
        ArrayList<Integer> res0=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
//            out.print(nums[i]);
            res0.add(nums[i]);
        }
//        out.println();
        res.add(res0);
        while(judge_modify(nums)){
            ArrayList<Integer> res_tmp=new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
//                out.print(nums[i]);
                res_tmp.add(nums[i]);
            }
//            out.println();
            res.add(res_tmp);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        com(nums,res);
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
