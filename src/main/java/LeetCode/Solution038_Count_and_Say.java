package LeetCode;

import java.util.Arrays;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */
public class Solution038_Count_and_Say {
    public String countAndSay(int n) {
        if(n==0) return "";
        if(n==1) return "1";
        if(n==2) return "11";
        if(n==3) return "21";
        if(n==4) return "1211";
        int[] res={1,2,1,1};
        int len_res=4;
        int order=4;
        while(order<n){
            int[] tmp=new int[len_res*2];
            int len=0;
            int last=res[0];
            int l=1;
            for(int i=1;i<len_res;i++){
                if(res[i]==res[i-1])
                    l++;
                else{
                    tmp[len++]=l;
                    tmp[len++]=last;
                    last=res[i];
                    l=1;
                }
            }
            tmp[len++]=l;
            tmp[len++]=last;
            res=tmp;
            len_res=len;
            order++;
        }
        StringBuilder strb=new StringBuilder();
        for(int i=0;i<len_res;i++){
            strb.append((char)('0'+res[i]));
        }
        return strb.toString();
    }
}
