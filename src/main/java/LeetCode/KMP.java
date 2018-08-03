package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.

 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class KMP {
    public int[] getnext(String ptr){
        char[] p=ptr.toCharArray();
        int len=p.length;
        int[] next=new int[len];
        next[0]=-1;

        int k=next[0];
        for(int q=1;q<len;q++){
            while(k>=0&&p[k+1]!=p[q])  //a  s   e   a   x   ....    a   s   e   a   s
                k=next[k];             //-1 -1  -1  0   -1  ....    0   1   2   3   1
            if(p[k+1]==p[q]) k=k+1;
            next[q]=k;
        }
        return next;
    }

    public int kmp(String str,String ptr){
        int[] next=getnext(ptr);
//        out.print("Next:");
//        for(int i=0;i<next.length;i++)
//            out.print(next[i]+" ");
//        out.println();
        char[] s=str.toCharArray();
        char[] p=ptr.toCharArray();
        int index_s=0,index_p=0;
        while(index_s<s.length){
            if(s[index_s]==p[index_p]){
                index_s++;
                index_p++;
                if(index_p==p.length)
                    return index_s-p.length;
            }
            else {
                if(index_p==0) index_s++;
                else{
                    index_p=next[index_p-1]+1;
//                    if(index_p==0) index_s++;
                }
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(haystack==null||haystack.equals("")) return -1;
        return kmp(haystack,needle);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String s=scan.nextLine();
        String p=scan.nextLine();
        out.println(new KMP().strStr(s,p));
    }
}
