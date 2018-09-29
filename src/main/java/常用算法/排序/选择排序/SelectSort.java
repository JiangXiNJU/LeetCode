package 常用算法.排序.选择排序;

/**
 * 时间复杂度 O(n*n)
 * n*(n-1)/2
 */
public class SelectSort {
    public static void selectsort(int[] nums){
        if(nums==null||nums.length<2) return;
        int len=nums.length;
        for(int i=0;i<len;i++){
            int min=nums[i],min_index=i;
            for(int j=i+1;j<len;j++){
                if(nums[j]<min){
                    min=nums[j];
                    min_index=j;
                }
            }
            nums[min_index]=nums[i];
            nums[i]=min;
        }
    }
}
