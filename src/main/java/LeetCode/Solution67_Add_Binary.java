package LeetCode;

/**
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"

 */
public class Solution67_Add_Binary {
    public String addBinary(String a, String b) {
        int lena=a.length(),lenb=b.length();
        char [] res=new char[Math.max(lena,lenb)+1];
        int indexa=lena-1,indexb=lenb-1,indexc=res.length-1;
        int cnt=0;
        while(indexa>=0&&indexb>=0){
            int num=a.charAt(indexa--)+b.charAt(indexb--)-2*'0'+cnt;
            cnt=num/2;
            res[indexc--]=(char)(num%2+'0');
        }
        if(indexa>=0){
            while(indexa>=0){
                int num=a.charAt(indexa--)-'0'+cnt;
                cnt=num/2;
                res[indexc--]=(char)(num%2+'0');
            }
        }
        else if(indexb>=0){
            while(indexb>=0){
                int num=b.charAt(indexb--)-'0'+cnt;
                cnt=num/2;
                res[indexc--]=(char)(num%2+'0');
            }
        }
        res[indexc--]=(char)(cnt+'0');
        String str=new String(res);
        if(res[0]=='0')
            str=str.substring(1,res.length);
        return str;
    }
}

