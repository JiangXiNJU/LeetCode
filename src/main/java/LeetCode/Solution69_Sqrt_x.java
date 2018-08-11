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
        int k=0,base=1;
        while(k<32){
            out.println("x: "+x+" , "+"base: "+base+" , k: "+k);
            if(x>base){
                base<<=2;
                k+=2;
            }
            else  break;
        }
        if(base==x){
            return 1<<(k/2);
        }
        base>>=2;
        k=k/2-1;
        int base_2=1<<(2*k);

        int from=k-1;
        while(from>=0){
            int square_base_add2powfrom=base_2+base<<(from+1)+1<<(from*2);
            if(square_base_add2powfrom<x){
                base_2=square_base_add2powfrom;
                base=base+1<<from;
            }
            from--;
        }
        return base;
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
