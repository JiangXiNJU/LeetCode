package LeetCode;

import static java.lang.System.out;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 艰难AC
 边界设置，f+1<b 解决死循环的出现，但同时也需要特殊处理

 */
public class Solution004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1==null||nums1.length==0)&&(nums2==null||nums2.length==0)) return 0.0;
        if(nums1==null||nums1.length==0) {
            if(nums2.length%2==1) return nums2[nums2.length/2];
            else return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;

        }
        if(nums2==null||nums2.length==0) {
            if(nums1.length%2==1) return nums1[nums1.length/2];
            else return (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
        }
        int remain=(nums1.length+nums2.length)/2-1;
        int f1=0,b1=Math.min(nums1.length,f1+remain),f2=0,b2=Math.min(nums2.length,f2+remain);//******* b的设置是关键，否则
        // 14，23过不了

        while(remain>0&&f1+1<b1&&f2+1<b2){
            int mid1=(f1+b1)/2,mid2=(f2+b2)/2;
            if(nums1[mid1]<=nums2[mid2]){
                remain-=mid1-f1;
                f1=mid1;
                b1=Math.min(f1+remain,b1);
                b2=Math.min(f2+remain,b2);
            }
            else{
                remain -= mid2 - f2;
                f2 = mid2 ;
                b2=Math.min(f2+remain,b2);
                b1=Math.min(f1+remain,b1);
            }
        }
        out.println("ramin: "+remain+" , f1: "+f1+" , f2: "+f2);
        if(remain>0){//仍有 优化空间
            while(remain>0){
                if(f1<nums1.length&&f2<nums2.length){
                    if(nums1[f1]<=nums2[f2]) f1++;
                    else f2++;
                }
                else if(f1<nums1.length) f1++;
                else f2++;
                remain--;
            }
        }

        out.println("ramin: "+remain+" , f1: "+f1+" , f2: "+f2);
        int val1=0,val2=0;
        if (f1 == nums1.length) {
            val1 = nums2[f2++];
            val2 = nums2[f2++];
        } else if (f2 == nums2.length) {
            val1 = nums1[f1++];
            val2 = nums1[f1++];
        }
        else {
            val1=nums1[f1]<=nums2[f2]?nums1[f1++]:nums2[f2++];
            if(f1==nums1.length) val2=nums2[f2++];
            else if(f2==nums2.length) val2=nums1[f1++];
            else val2=nums1[f1]<=nums2[f2]?nums1[f1++]:nums2[f2++];
        }
        out.println("val1: "+val1+" , val2: "+val2);
        if((nums1.length+nums2.length)%2==1) return val2;
        else  return (val1+val2)/2.0;
    }

    public static void main(String[] args) {
        int[] nums1={1,4};
        int[] nums2={2,3};
        out.println(new Solution004_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(nums1,nums2));
    }
}
