package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"
 */
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1) return 0;
        int[] dp=new int[s.length()];
        int left=0,right=0;
        int max=0;
        int last=0;
        int tmp=0;
        dp[0]=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                dp[i]=0;
            }
            else{
                if(s.charAt(i-1)==')') {
                    if(i-1-2*dp[i-1]>=0&&s.charAt(i-1-2*dp[i-1])=='('){
                        dp[i] = dp[i - 1] + 1;
                        int front=i-1-2*dp[i-1];
                        if(front-1>=0&&s.charAt(front-1)==')')
                            dp[i]+=dp[front-1];
                    }
                    else dp[i]=0;
                }
                else{
                    if(i-2>=0) dp[i]=dp[i-2]+1;
                    else dp[i]=1;
                }
                if(dp[i]>max) max=dp[i];
            }
        }
        ;
        return max*2;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

        String str=scan.nextLine();
        out.println(new Longest_Valid_Parentheses().longestValidParentheses(str));
    }
}
