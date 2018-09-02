package LeetCode;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Corner Cases:

 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Solution71_Simplify_Path {
    public StringBuilder getPath(StringBuilder res,Stack<String> s){
        if(s.isEmpty()) {
            return res;
        }
        String now=s.pop();
        res=getPath(res,s);
        res.append("/");
        res.append(now);
        return res;
    }
    public String simplifyPath(String path) {
        if(path==null||path.length()==0) return "/";
        Stack<String> s=new Stack<String>();
        int index=0;
        while(index<path.length()){
            if(path.charAt(index)!='/'){

                StringBuilder sb=new StringBuilder();
                while(index<path.length()&&path.charAt(index)!='/'){
                    sb.append(path.charAt(index));
                    index++;
                }
                String str=sb.toString();
                if(str.equals(".")){}
                else if(str.equals("..")){
                    if(!s.isEmpty()) s.pop();
                }
                else s.push(sb.toString());
            }
            else index++;
        }
        if(s.isEmpty()) return "/";
        StringBuilder res=new StringBuilder();
        return getPath(res,s).toString();
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Solution71_Simplify_Path so=new Solution71_Simplify_Path();
        String path=scan.nextLine();
        out.println(so.simplifyPath(path));
    }
}
