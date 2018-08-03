package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */
public class Reverse_Integer {
    public int reverse(int x){
        if(x>=-9&&x<=9) return x;
        String s=Integer.toString(x);
        char[] chars=s.toCharArray();
        int len=chars.length;
        int f=0,b;
        if(chars[0]=='-'||chars[0]=='+') f=1;
        b=len-1;
        while(b>=f&&chars[b]=='0') b--;
        int len_n=(b-f+1);
        out.println("f: "+f+" , b: "+b+" , len_n: "+len_n);
        for(int i=0;i<len_n/2;i++){
            char tmp=chars[f+i];
            chars[f+i]=chars[b-i];
            chars[b-i]=tmp;
        }
        if(f==1) f--;
        long res_b=Long.parseLong(new String(chars).substring(f,b+1));
        if(res_b<Integer.MIN_VALUE||res_b>Integer.MAX_VALUE) return 0;
        return (int) res_b;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        int x=scan.nextInt();

        out.println(new Reverse_Integer().reverse(x));
    }
}
