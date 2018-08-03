package LeetCode;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        if(s==null||s.equals("")) return true;
        int index=0;
        Stack<Character> stack=new Stack<Character>();
        while(index<s.length()){
            char  ch=s.charAt(index);
            if(ch=='('||ch=='{'||ch=='[')
                stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                char m=stack.pop();
                if(ch==')'&&m!='(') return false;
                if(ch=='}'&&m!='{') return false;
                if(ch==']'&&m!='[') return false;
            }
            index++;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String s=scan.nextLine();
        Valid_Parentheses v=new Valid_Parentheses();
        out.println(v.isValid(s));
    }
}
