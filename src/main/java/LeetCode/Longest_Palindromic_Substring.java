package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 两种方法，一是dp，n方时间复杂度，n方空间复杂度；二是从中心点扩展，n方时间复杂度，n空间复杂度
 还有更快的方法，看Solution
 */
public class Longest_Palindromic_Substring {
    public String longestPalindrome_dp(String s) {
        if(s==null||s.length()<=1) return s;
//        out.println("s: "+s);
        char[] chars=s.toCharArray();
        boolean[][] dp=new boolean[chars.length+1][chars.length+1];
        for(int i=1;i<chars.length+1;i++)
            for(int j=1;j<chars.length+1;j++)
                dp[i][j]=false;
        int max=1;
        int len=chars.length;
        int f=len-1,b=len;
        dp[len-1][1]=true;
//        out.println(res);
        for(int i=len-2;i>=0;i--){
            dp[i][1]=true;
            if(chars[i]==chars[i+1]) {
                dp[i][2]=true;
                if(2>max){
                    max=2;
                    f=i;
                    b=i+2;
//                    out.println(res);
                }
            }
            for(int j=3;j<=len-i;j++){
                if(!dp[i+1][j-2]) continue;
//                out.println("i: "+i+" , i+j-1: "+(i+j-1)+"  "+chars[i]+" , "+((i+j-1)<len?(chars[i+j-1]):("null")));
                if(i+j-1<len&&chars[i]==chars[i+j-1]){
                    dp[i][j]=true;
                    if(j>max){
                        max=j;
                        f=i;
                        b=i+j;
//                        out.println(res);
                    }
                }
            }
        }
        System.out.println("res: "+s.substring(f,b));
        return s.substring(f,b);
    }

    public String longestPalindrome_center(String s) {
        if(s==null||s.length()<=1) return s;
        char[] chars=s.toCharArray();
        int max=1;
        int len=chars.length;
        int f=0,b=1;

        for(int i=0;i<len-1;i++){
            if(chars[i]==chars[i+1]){
                int tmp_max=2;
                int j=1;
                while(j<=Math.min(i,len-2-i)&&chars[i-j]==chars[i+1+j]) j++;
                tmp_max+=2*(j-1);
                if(tmp_max>max){
                    max=tmp_max;
                    f=i-j+1;
                    b=i+1+j;
                }
            }
            if(i>=1&&chars[i-1]==chars[i+1]){
                int tmp_max=1;
                int j=1;
                while(j<=Math.min(i,len-i-1)&&chars[i-j]==chars[i+j]) j++;
                tmp_max+=2*(j-1);
                if(tmp_max>max){
                    max=tmp_max;
                    f=i-j+1;
                    b=i+j;
                }
            }
        }

        System.out.println("res: "+s.substring(f,b));
        return s.substring(f,b);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String s=scan.nextLine();
        String res=new Longest_Palindromic_Substring().longestPalindrome_center(s);
    }
}
