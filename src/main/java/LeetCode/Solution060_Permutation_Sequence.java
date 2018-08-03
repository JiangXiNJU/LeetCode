package LeetCode;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"
 */
public class Solution060_Permutation_Sequence {
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public String getPermutation(int n, int k) {
        if(n==0) return "";
        if(n==1) return "1";
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        int order=1;
        if(order==k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++)
                sb.append((char)('0'+nums[i]));
            return sb.toString();
        }

        int[] mul=new int[n];
        mul[0]=1;
        for(int i=1;i<n;i++)
            mul[i]=(i+1)*mul[i-1];
        int c=n;
        for(int i=0;i<n;i++){
            if(k<nums[i]){
                c=i;
                break;
            }
        }
        if(c==n){
            for(int i=0;i<n/2;i++)
                swap(nums,i,n-i);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++)
                sb.append((char)('0'+nums[i]));
            return sb.toString();
        }

        int number=k/nums[c-1];
        nums[0]=number;
        for(int i=1;i<n;i++){
//            bfgvb
        }

        boolean flag=true;
        while(flag){
            order++;
            int index=n-1;
            while(index>=1&&nums[index-1]>nums[index]) index--;
            if(index==0) break;
            index--;
            int index_2=n-1;
            while(index_2>index&&nums[index_2]<nums[index]) index_2--;
            swap(nums,index,index_2);

            int f=index+1,b=n-1;
            for(int i=0;i<(b-f+1)/2;i++)
                swap(nums,f+i,b-i);

            if(order==k){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++)
                    sb.append((char)('0'+nums[i]));
                return sb.toString();
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append((char)('0'+nums[i]));
        return sb.toString();
    }
}
