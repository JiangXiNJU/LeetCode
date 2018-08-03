package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 Note:

 Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Solution041_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        if(nums.length==1){
            if(nums[0]==1) return 2;
            else return 1;
        }

        int min=nums[0];
        int max=nums[0];
        int num_minus=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0) num_minus++;
            else {
                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }
        }
        if(min>1) return 1;
        int should_max=nums.length-num_minus;

        int index=0;
        for(int i=0;i<nums.length;i++)
            out.print(nums[i]+" ");
        out.println();
        while(index<nums.length){
            int index_c=index;
            while(nums[index_c]!=index_c+1&&nums[index_c]>0){
                int next_index=nums[index_c];
                if(next_index-1<nums.length&&nums[next_index-1]!=next_index){
                    int tmp=nums[next_index-1];
                    nums[next_index-1]=next_index;
                    nums[index_c]=tmp;
                }
                else break;
            }
            for(int i=0;i<nums.length;i++)
                out.print(nums[i]+" ");
            out.println();
            index++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int[] nums={2,1};
        out.println(new Solution041_First_Missing_Positive().firstMissingPositive(nums));
    }
}
