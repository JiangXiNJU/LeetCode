package 常用算法.排序.插入排序;

/**
 * 时间复杂度 O(n*n)
 * 正序最佳为O(n)，逆序最差为O(n*n)
 */
public class InsertSort {
    public static void insertsort(int[] nums){
        if(nums==null||nums.length<2) return;
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            int index=i-1;
            int target=nums[i];
            while(index>=0&&target<nums[index]){
                nums[index+1]=nums[index];
                index--;
            }
            nums[index+1]=target;
        }
    }
}
