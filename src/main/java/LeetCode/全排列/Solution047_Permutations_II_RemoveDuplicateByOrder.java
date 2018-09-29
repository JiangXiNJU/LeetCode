package LeetCode.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static 常用算法.排序.交换排序.BubbleSort.cocktail_sort;

/**
 * Created by cycy on 2018/9/3.
 * 比用Set去重更快！
 */
public class Solution047_Permutations_II_RemoveDuplicateByOrder {
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
    public void reverse(int[] nums,int f,int b){
        while(f < b){
            swap(nums, f, b);
            f++;
            b--;
        }
    }
    public boolean nextPermutation(int[] nums) {
        if(nums==null||nums.length<2) return false;
        int index_f=nums.length-2;
        while (index_f>=0&&nums[index_f]>=nums[index_f+1]) index_f--;

        if(index_f>=0){
            int index_b=nums.length-1;
            while(index_b>index_f&&nums[index_b]<=nums[index_f]) index_b--;
//        out.println("index_f,index_b: "+index_f+","+index_b);
            swap(nums,index_f,index_b);
            reverse(nums,index_f+1,nums.length-1);
            return true;
        }
        return false;

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
//        cocktail_sort(nums);
        res.add(fill(nums));
        while(nextPermutation(nums)) res.add(fill(nums));
        return res;
    }

}
