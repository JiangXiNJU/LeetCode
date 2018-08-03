package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Generate_Parentheses {
    public void recur (int left,int right,int n,String str,ArrayList res){
        if(left+right==2*n-1&&right==left-1){
            res.add(str+")");
            return;
        }
        if(left>right){
            recur(left,right+1,n,str+")",res);
            if(left<n) recur(left+1,right,n,str+"(",res);
            return;
        }
        else if(left==right&&left<n){
            recur(left+1,right,n,str+"(",res);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<String>();
        if(n==0) return res;
        recur(0,0,n,"",res);
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int n=scan.nextInt();
        ArrayList res=(ArrayList) new Generate_Parentheses().generateParenthesis(n);
        for(int i=0;i<res.size();i++)
            out.println(res.get(i));
    }
}
