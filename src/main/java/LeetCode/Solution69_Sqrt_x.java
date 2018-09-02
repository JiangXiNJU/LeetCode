package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.

 */
public class Solution69_Sqrt_x {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int f=1,b=x;
        while(f<=b){
            long mid=f+(b-f)/2;
            if(mid*mid<x) f=(int)mid+1;
            else if(mid*mid>x) b=(int)mid-1;
            else return (int)mid;
        }
        return f-1;
    }

    public static void main(String[] args) {
        Solution69_Sqrt_x s=new Solution69_Sqrt_x();
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            int x = scan.nextInt();
            out.println("true num= " + (int) Math.sqrt(x));
            out.println("my num= " + s.mySqrt(x));
        }
    }
}
