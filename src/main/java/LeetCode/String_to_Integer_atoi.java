package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.

 Note:

 Only the space character ' ' is considered as whitespace character.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 Example 1:

 Input: "42"
 Output: 42
 Example 2:

 Input: "   -42"
 Output: -42
 Explanation: The first non-whitespace character is '-', which is the minus sign.
 Then take as many numerical digits as possible, which gets 42.
 Example 3:

 Input: "4193 with words"
 Output: 4193
 Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 Example 4:

 Input: "words and 987"
 Output: 0
 Explanation: The first non-whitespace character is 'w', which is not a numerical
 digit or a +/- sign. Therefore no valid conversion could be performed.
 Example 5:

 Input: "-91283472332"
 Output: -2147483648
 Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 Thefore INT_MIN (−231) is returned.
 */
public class String_to_Integer_atoi {
    public int judge(String str){
        if(str==null||str.length()==0) return -1;
        int i=0;
        while(i<str.length()&&str.charAt(i)==' ') i++;
        if(i>=str.length()) return -1;
        if(str.charAt(i)!='-'&&str.charAt(i)!='+'&&str.charAt(i)<'0'&&str.charAt(i)>'9') return -1;
        int start=i;
        if(str.charAt(i)=='-'||str.charAt(i)=='+') i++;
        if(i>=str.length()) return -1;
        if(str.charAt(i)<'0'&&str.charAt(i)>'9') return -1;
        return start;
    }
    public int myAtoi(String str) {
        int start=judge(str);
        if(start==-1) return 0;
        long res=0;
        int symbol=1;
        if(str.charAt(start)=='-'||str.charAt(start)=='+') {
            if(str.charAt(start)=='-') symbol=-1;
            start++;
        }
        int index=start;
        while(index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
            res=res*10+str.charAt(index)-'0';
            //out.println("res: "+res);
            if(res*symbol>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res*symbol<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;
        }
        return (int) res*symbol;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int max=Integer.MAX_VALUE;
        out.println(max+1);

        String_to_Integer_atoi s=new String_to_Integer_atoi();
        String str=scan.nextLine();
        out.println(s.myAtoi(str));
    }
}
