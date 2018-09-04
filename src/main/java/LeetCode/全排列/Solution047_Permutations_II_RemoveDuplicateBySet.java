package LeetCode.全排列;

import java.util.*;

import static java.lang.System.out;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 有重复，加一个set进行去重即可，保证每一位上的候选人不会出现重复值
 */
public class Solution047_Permutations_II_RemoveDuplicateBySet {
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
            HashSet<Integer> set=new HashSet<Integer>();
            for(int j=start;j<nums.length;j++){
                if(set.contains(nums[j])==false) {
                    set.add(nums[j]);
                    swap(nums, j, start);
                    recur(nums, start + 1, res);
                    swap(nums, j, start);
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        List<List<Integer>> res=new Solution047_Permutations_II_RemoveDuplicateBySet().permuteUnique(num);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<n;j++){
                out.print(res.get(i).get(j));
            }
            out.println();
        }
    }
}
