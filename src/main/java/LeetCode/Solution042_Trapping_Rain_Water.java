package LeetCode;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;
import static java.lang.System.out;
import static javafx.scene.input.KeyCode.M;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 [9,6,8,8,5,6,3]
 {2,5,3,2,3,1,4,0,5,0,4,7,2,4,3,9}
 */
public class Solution042_Trapping_Rain_Water {

    public int trap_dp(int[] height) {
        if(height==null||height.length<=1) return 0;
        int ans=0;
       int[] left_max=new int[height.length];
        int[] right_max=new int[height.length];
        int max_left=height[0];
        int max_right=height[height.length-1];
        int len_1=height.length-1;
        for(int i=0;i<height.length;i++){
            if(height[i]>max_left) max_left=height[i];
            left_max[i]=max_left;
            if(height[len_1-i]>max_right) max_right=height[len_1-i];
            right_max[len_1-i]=max_right;
        }

//        for(int i=0;i<height.length;i++)
//            out.print(left_max[i]);
//        out.println();
//        for(int i=0;i<height.length;i++)
//            out.print(right_max[i]);
//        out.println();

        for(int i=0;i<height.length;i++){
            ans+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;
    }
    public int trap(int[] height){
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max)
                    left_max = height[left];
                else ans += (left_max - height[left]);
                ++left;
            }
            else {
                if(height[right] >= right_max)
                    right_max = height[right] ;
                else ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int[] nums={9,6,8,8,5,6,3};
        out.println(new Solution042_Trapping_Rain_Water().trap(nums));
    }
}

