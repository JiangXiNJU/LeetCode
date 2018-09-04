package LeetCode.全排列;

import java.util.LinkedList;
import java.util.List;

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
    public String getPermutation(int n, int k) {
        if(n==0) return "";
        if(n==1) return "1";
        List<Integer> nums=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            nums.add(i+1);
        StringBuilder sb=new StringBuilder();
        int[] multiply=new int[n+1];
        multiply[0]=0;
        multiply[1]=1;
        for(int i=2;i<=n;i++)
            multiply[i]=i*multiply[i-1];

        int remain=k-1;
        for(int i=1;i<n;i++){
            int index=remain/multiply[n-i];
            remain%=multiply[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
        }
        sb.append(nums.get(remain));
        return sb.toString();
    }
}
