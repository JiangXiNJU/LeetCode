package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input:
 s = "cb"
 p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 Example 4:

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 Example 5:

 Input:
 s = "acdcb"
 p = "a*c?b"
 Output: false

babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb
b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a

abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb
***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**
 *
mississippi
m??*ss*?i*pi
 *
 * 复杂度太高
 */
public class Solution044_Wildcard_Matching {
    public boolean recur(char[] s,char[] p,int index_s,int index_p,int left_p){
        if(s.length-index_s<left_p) return false;
        if(index_s==s.length){
            if(index_p==p.length) return true;
            else if(index_p==p.length-1&&p[index_p]=='*') return true;
            else return false;
        }
        if(index_p==p.length) return false;

         if(s[index_s]==p[index_p]||p[index_p]=='?') return recur(s,p,index_s+1,index_p+1,left_p-1);

        if(p[index_p]=='*') {
            if(index_p==p.length-1) return true;

        }

        return false;
    }
    public boolean isMatch(String s, String p) {
        if(s==null&&p==null) return true;
        if(s.length()==0&&p.length()==0) return true;
        if((s==null||s.length()==0)&&((p!=null&&p.length()!=0)&&p.equals("*"))) return true;
        if((p==null||p.length()==0)&&s.length()!=0) return false;
        char[] str=s.toCharArray();
        ArrayList<Character> p_l=new ArrayList<Character>();
        for(int i=0;i<p.length()-1;i++){
            if(p.charAt(i)==p.charAt(i+1)&&p.charAt(i)=='*') continue;
            p_l.add(p.charAt(i));
        }
        p_l.add(p.charAt(p.length()-1));
        char[] ptr=new char[p_l.size()];
        int left_p=0;
        for(int i=0;i<p_l.size();i++){
            ptr[i]=p_l.get(i);
            if(ptr[i]!='*') left_p++;
        }

        out.print("s: ");
        for(int i=0;i<str.length;i++)
            out.print(str[i]);
        out.println();
        out.print("p: ");
        for(int i=0;i<ptr.length;i++)
            out.print(ptr[i]);
        out.println();

        int index_s=0,index_p=0;
        return recur(str,ptr,index_s,index_p,left_p);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String s=scan.nextLine();
        String p=scan.nextLine();
        out.println(new Solution044_Wildcard_Matching().isMatch(s,p));
    }
}
