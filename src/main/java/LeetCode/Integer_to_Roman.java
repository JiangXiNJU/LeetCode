package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together.
 Twelve is written as, XII, which is simply X + II.
 The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right.
 However, the numeral for four is not IIII. Instead, the number four is written as IV.
 Because the one is before the five we subtract it making four.
 The same principle applies to the number nine, which is written as IX.

 There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: 3
 Output: "III"
 Example 2:

 Input: 4
 Output: "IV"
 Example 3:

 Input: 9
 Output: "IX"
 Example 4:

 Input: 58
 Output: "LVIII"
 Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 Example 5:

 Input: 1994
 Output: "MCMXCIV"
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Integer_to_Roman {
    public String intToRoman(int num) {
        if(num/1000>0) {
            String res="";
            for(int i=num/1000;i>0;i--)
                res+="M";
            return res+intToRoman(num%1000);
        }
        if(num/100>0){
            if(num/100==9) return "CM"+intToRoman(num%100);
            if(num/100==4) return "CD"+intToRoman(num%100);
            String res="";
            if(num/100>=5) res="D";
            for(int i=num/100>=5?num/100-5:num/100;i>0;i--)
                res+="C";
            return res+intToRoman(num%100);
        }
        if(num/10>0){
            if(num/10==9) return "XC"+intToRoman(num%10);
            if(num/10==4) return "XL"+intToRoman(num%10);
            String res="";
            if(num/10>=5) res="L";
            for(int i=num/10>=5?num/10-5:num/10;i>0;i--)
                res+="X";
            return res+intToRoman(num%10);
        }
        if(num==9) return "IX";
        if(num==4) return "IV";
        else{
            String res="";
            if(num>=5) res="V";
            for(int i=num>=5?num-5:num;i>0;i--)
                res+="I";
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

        int n=scan.nextInt();
        out.println(new Integer_to_Roman().intToRoman(n));
    }
}
