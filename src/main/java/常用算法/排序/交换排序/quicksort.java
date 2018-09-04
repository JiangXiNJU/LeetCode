package 常用算法.排序.交换排序;

/**
 * Created by cycy on 2018/9/3.
 */
public class quicksort {

    public static void quicksort(int[] nums,int f, int b){
        if(f>=b) return;
        int mid=partition(nums,f,b);
        if(mid-1>f) quicksort(nums,f,mid-1);
        if(mid+1<b) quicksort(nums,mid+1,b);
    }
    public static int partition(int[] nums,int f,int b){
        int mid=f+(b-f)/2;
        int target=nums[mid];
        swap(nums)
        int start=f,end=b;
        while(start<end){
            if(nums[start]<=target) start++;
        }
    }
}
