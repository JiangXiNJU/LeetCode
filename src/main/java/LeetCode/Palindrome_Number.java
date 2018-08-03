package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?


易错
 1000110001
 前有0 后有0 必须同时更新
 */
public class Palindrome_Number {
    public int getbit(int x){
        int num_bit=0;
        int temp=x;
        while(temp>0){
            temp/=10;
            num_bit++;
        }
        return num_bit;
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x<10) return true;
        int num_bit=0;
        int temp=x;
        while(temp>0){
            temp/=10;
            num_bit++;
        }
        out.println("bit : "+num_bit);
        while(x>=10){
            int f=x/(int)Math.pow(10,num_bit-1);
            int b=x%10;
            if(f!=b) return false;
            x=x%(int)Math.pow(10,num_bit-1)/10;
            out.println(x);
            num_bit-=2;
            int new_bit=getbit(x);
            if(new_bit!=num_bit){
                out.println("new_bit: "+new_bit+" num_bit: "+num_bit);
                int diff=num_bit-new_bit;
                while(diff>0&&x>0){
                    if(x%10!=0) return false;
                    diff--;
                    x/=10;
                }
                num_bit=getbit(x);
                out.println(x);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        out.println(new Palindrome_Number().isPalindrome(scan.nextInt()));
    }
}
