package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Follow up:

 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's,
 then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?

 */
public class Solution075_Sort_Colors {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1) return;
        int end_0=-1,start_2=nums.length;
        while(end_0+1<start_2&&nums[end_0+1]==0) end_0++;
        while(start_2-1>=0&&nums[start_2-1]==2) start_2--;
        int index=end_0+1;
        while(index<start_2){
            if(nums[index]==0){
                if(index==end_0+1){
                    end_0++;
                    while(end_0+1<start_2&&nums[end_0+1]==0) end_0++;
                    index=end_0+1;
                }
                else {
                    nums[index]=nums[end_0+1];
                    nums[end_0+1]=0;
                    end_0++;
                }
            }
            else if(nums[index]==2){
                if(index==start_2-1){
                    start_2--;
                    index++;
                }
                else{
                    nums[index]=nums[start_2-1];
                    nums[start_2-1]=2;
                    start_2--;
                    while(start_2-1>=0&&nums[start_2-1]==2) start_2--;
                }
            }
            else index++;
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int[] nums={2,0,2,1,1,0};
        new Solution075_Sort_Colors().sortColors(nums);
        for(int i=0;i<nums.length;i++)
            out.print(nums[i]);
        out.println();
    }
}
