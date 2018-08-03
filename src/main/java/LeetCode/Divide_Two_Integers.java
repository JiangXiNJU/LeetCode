package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Note:

 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 [−231,  231 − 1].
 For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.


 -1010369383
 -2147483648
 */
public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        /**
         * 以下为处理越界情况
         */
        if(divisor==Integer.MIN_VALUE){// Integer.MAX_VALUE<<1=-2
            if(dividend==Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;

        int symbol;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)) symbol=1;
        else symbol=-1;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        if(divisor==1) {
            if(symbol==-1) {
                return ~dividend+1;
            }
            return dividend;
        };

        int num_2_bit=0;
        int tmp=divisor;
        while((tmp<<1)>tmp){
            num_2_bit+=1;
            tmp=tmp<<1;
        }

        int sum=0;
        for(int i=num_2_bit;i>=1;i--){
            while(dividend-(divisor<<i)>=0){
                sum+=1<<i;
                dividend-=divisor<<i;
            }
        }
        while(dividend-divisor>=0){
            sum++;
            dividend-=divisor;
        }

        if(symbol==-1) return ~sum+1;
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        out.println(Integer.MAX_VALUE<<1);
        int a=scan.nextInt();
        int b=scan.nextInt();

        out.println(new Divide_Two_Integers().divide(a,b));
    }
}
