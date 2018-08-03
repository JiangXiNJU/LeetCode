package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution043_Multiply_Strings {
    public int[] multi(int[] a,int[] b){

//        for(int i=0;i<a.length;i++)
//            out.print(a[i]);
//        out.println();
//        for(int i=0;i<b.length;i++)
//            out.print(b[i]);
//        out.println();

        int[][] mid_res=new int[b.length][a.length+b.length+1];
        for(int i=0;i<b.length;i++){
            mid_res[i]=new int[a.length+b.length+1];
            int cnt=0;
            for(int j=0;j<a.length;j++){
                mid_res[i][j+i]=(b[i]*a[j]+cnt)%10;
                cnt=(b[i]*a[j]+cnt)/10;
            }
            mid_res[i][a.length+i]=cnt;
        }
        int[] tmp_res=new int[a.length+b.length+1];
        int cnt=0;
        for(int i=0;i<a.length+b.length+1;i++){
            int sum=0;
            for(int j=0;j<b.length;j++){
                sum+=mid_res[j][i];
            }
            sum+=cnt;
            tmp_res[i]=sum%10;
            cnt=sum/10;
        }
        int limit=tmp_res.length;
        while(limit>=1&&tmp_res[limit-1]==0) limit--;
        int[] res=new int[limit];
        System.arraycopy(tmp_res,0,res,0,limit);
        return res;
    }
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0) return "0";
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] a,b;
        if(num1.length()<num2.length()){
            a=new int[num2.length()];
            b=new int[num1.length()];
            for(int i=num2.length()-1;i>=num1.length();i--)
                a[num2.length()-1-i]=num2.charAt(i)-'0';
            for(int i=num1.length()-1;i>=0;i--){
                a[num2.length()-1-i]=num2.charAt(i)-'0';
                b[num1.length()-1-i]=num1.charAt(i)-'0';
            }
        }
        else{
            a=new int[num1.length()];
            b=new int[num2.length()];
            for(int i=num1.length()-1;i>=num2.length();i--)
                a[num1.length()-1-i]=num1.charAt(i)-'0';
            for(int i=num2.length()-1;i>=0;i--){
                a[num1.length()-1-i]=num1.charAt(i)-'0';
                b[num2.length()-1-i]=num2.charAt(i)-'0';
            }
        }
        int[] res_int=multi(a,b);
        StringBuilder str=new StringBuilder();
        for(int i=res_int.length-1;i>=0;i--)
            str.append((char)('0'+res_int[i]));
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String a=scan.nextLine();
        String b=scan.nextLine();
        out.println(new Solution043_Multiply_Strings().multiply(a,b));
    }
}
