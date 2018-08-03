package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;
import static jdk.nashorn.internal.parser.TokenType.IF;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false

 aaaaaaaaaaaaab
 a*a*a*a*a*a*a*a*a*a*a*a*b
 重复的模式折叠
 */
public class Regular_Expression_Matching {
    public boolean judge(String s,String p,int i_s,int i_p){
        if(i_s==s.length()&&i_p==p.length()) return true;
        if(i_s==s.length()){
            if(i_p+1<p.length()&&p.charAt(i_p+1)=='*') return judge(s,p,i_s,i_p+2);
            else return false;
        }
        if(i_p==p.length()) return false;

        if(i_p+1<p.length()&&p.charAt(i_p+1)=='*'){
            while(i_p+3<p.length()&&p.charAt(i_p+3)=='*'&&p.charAt(i_p)==p.charAt(i_p+2)) i_p+=2;
        }
        boolean res=false;
        char ch_s=s.charAt(i_s);
        char ch_p=p.charAt(i_p);
        if(ch_s!=ch_p&&ch_p!='.') {
            if (i_p + 1 < p.length() && p.charAt(i_p + 1) == '*') {
                res = res | judge(s, p, i_s, i_p + 2);
                if (res) return res;
            }
            else return false;
        }
        else{//相等，考虑*的情况
            if(i_p+1<p.length()&&p.charAt(i_p+1)=='*'){
                res=res|judge(s,p,i_s+1,i_p+2)|judge(s,p,i_s+1,i_p)|judge(s,p,i_s,i_p+2);
            }
            else{
                return judge(s,p,i_s+1,i_p+1);
            }
        }
        return res;
    }
    public boolean isMatch(String s, String p) {
        if(s==null&&p==null) return true;
        if(s.equals("")&&p.equals("")) return true;
        if(s.length()>0&&(p==null||p.length()==0)) return false;
        int i_s=0,i_p=0;
        return judge(s,p,i_s,i_p);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String s=scan.nextLine();
        String p=scan.nextLine();
        out.println(new Regular_Expression_Matching().isMatch(s,p));
    }
}
