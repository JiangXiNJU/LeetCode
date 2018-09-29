package 常用算法;

/**
 * Created by cycy on 2018/9/4.
 */
public class BinarySearch {
    public static boolean search(int[] nums,int target){
        int f=0,b=nums.length-1;
        while(f<=b){
            int mid=f+(b-f)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]<target) f=mid+1;
            else b=mid-1;
        }
        return false;
    }
}
