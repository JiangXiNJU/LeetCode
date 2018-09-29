package 常用算法.排序.交换排序;

/**
 * Created by cycy on 2018/9/3.
 */
public class QuickSort {
    public static void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

    public static int partition(int[] nums,int f,int b){
        int mid=f+(b-f)/2;
        int target=nums[mid];
        swap(nums,mid,b);
        int start=f,end=b;
        while(start<end){
            while(start<end&&nums[start]<=target) start++;
            if(start==end) break;
            nums[end]=nums[start];
            end--;
            while(end>start&&nums[end]>target) end--;
            if(start==end) break;
            nums[start]=nums[end];
            start++;
        }
        nums[start]=target;
        return start;
    }

    public static void quicksort(int[] nums,int f, int b){
        if(f>=b) return;
        int mid=partition(nums,f,b);
        if(mid-1>f) quicksort(nums,f,mid-1);
        if(mid+1<b) quicksort(nums,mid+1,b);
    }

}
