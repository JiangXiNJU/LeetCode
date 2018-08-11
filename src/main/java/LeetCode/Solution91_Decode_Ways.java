package LeetCode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 Example 1:

 Input: "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 Example 2:

 Input: "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 DP+空间压缩
 */
public class Solution91_Decode_Ways {
    public int dp(char[] s){
        int sum=0;
        if(s[0]=='0') return 0;
        if(s.length==1) return 1;

        int dp1=0,dp2=1;
        if(s[1]=='0') {
            if(s[0]=='0'||s[0]>'2') return 0;
            dp2=1;
        }
        else {
            dp1=1;
            if(s[0]=='1'||(s[0]=='2'&&s[1]<='6')) dp2=2;
            else dp2=dp1=1;
        }

        for(int i=2;i<s.length;i++){
            if(s[i]=='0'){
                if(s[i-1]=='0'||s[i-1]>'2') return 0;
                else dp2=dp1;

            }
            else if(s[i-1]=='0') dp1=dp2;
            else{
                if(s[i-1]=='1'||(s[i-1]=='2'&&s[i]<='6')) {
                    dp2+=dp1;
                    dp1=dp2-dp1;
                }
                else dp1=dp2;
            }
        }
        return dp2;
    }
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        return dp(s.toCharArray());
    }
}
