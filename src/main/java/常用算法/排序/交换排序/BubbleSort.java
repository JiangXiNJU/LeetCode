package 常用算法.排序.交换排序;

/**
 * 时间复杂度 O(n*n)
 * 正序最佳为O(n)，逆序最差为O(n*n)
 */
public class BubbleSort {
    public static void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public static void sort1(int[] nums){
        if(nums==null||nums.length<2) return;
        int len=nums.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-1;j++){
                if(nums[j]>nums[j+1]) swap(nums,j+1,j);
            }
        }
    }
    //优化结束条件
    public static void sort2(int[] nums){
        if(nums==null||nums.length<2) return;
        int len=nums.length;
        boolean tobe_continued=true;
        for(int i=0;i<len&&tobe_continued;i++){
            tobe_continued=false;
            for(int j=0;j<len-1;j++){
                if(nums[j]>nums[j+1]) {
                    swap(nums,j+1,j);
                    tobe_continued=true;
                }
            }
        }
    }

    //优化循环条件
    public static void sort3(int[] nums){
        if(nums==null||nums.length<2) return;
        int len=nums.length;
        boolean tobe_continued=true;
        for(int i=0;i<len&&tobe_continued;i++){
            tobe_continued=false;
            for(int j=0;j<len-1-i;j++){
                if(nums[j]>nums[j+1]) {
                    swap(nums,j+1,j);
                    tobe_continued=true;
                }
            }
        }
    }

    //双向进行
    public static void cocktail_sort(int[] nums){
        if(nums==null||nums.length<2) return;
        int begin=0,end=nums.length-1;
        while(begin<end){
            int endt=begin;
            for(int i=begin;i<end;i++){
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                    endt=i;
                }
            }
            end=endt;
            int begint=end;
            for(int i=end;i>begin;i--){
                if(nums[i]<nums[i-1]){
                    swap(nums,i,i-1);
                    begint=i;
                }
            }
            begin=begint;
        }
    }
}
