package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order, your answer could be in any order you want.


 */
public class Letter_Combinations_of_a_Phone_Number {
    public boolean add(int[] num,int[] lens,char[] d){
        int len=d.length;
        int cnt=(num[len-1]+1)/lens[d[len-1]-'0'];
        num[len-1]=(num[len-1]+1)%lens[d[len-1]-'0'];
        int index=len-2;
        while(cnt>0&&index>=0){
            cnt=(num[index]+1)/lens[d[index]-'0'];
            num[index]=(num[index]+1)%lens[d[index]-'0'];
            index--;
        }
        if(index>=0||cnt==0) return true;
        else return false;
    }
    public List<String> letterCombinations(String digits) {
        ArrayList res=new ArrayList();
        if(digits==null||digits.length()==0) return res;
        char[][] dic=new char[10][];
        dic[2]="abc".toCharArray();
        dic[3]="def".toCharArray();
        dic[4]="ghi".toCharArray();
        dic[5]="jkl".toCharArray();
        dic[6]="mno".toCharArray();
        dic[7]="pqrs".toCharArray();
        dic[8]="tuv".toCharArray();
        dic[9]="wxyz".toCharArray();
        int[] lens={0,0,3,3,3,3,3,4,3,4};
        char[] d=digits.toCharArray();
        int[] num=new int[d.length];

//        for(int i=0;i<d.length;i++)
//            out.print(num[i]);
//        out.println();
        char[] str0=new char[d.length];
        for(int i=0;i<d.length;i++)
            str0[i]=dic[d[i]-'0'][num[i]];
        res.add(new String(str0));

        while(add(num,lens,d)){
//            for(int i=0;i<d.length;i++)
//                out.print(num[i]);
//            out.println();
            char[] str=new char[d.length];
            for(int i=0;i<d.length;i++)
                str[i]=dic[d[i]-'0'][num[i]];
            res.add(new String(str));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();
        String str=scan.nextLine();
        Letter_Combinations_of_a_Phone_Number s=new Letter_Combinations_of_a_Phone_Number();
        ArrayList<String> res=(ArrayList<String>) s.letterCombinations(str);
        for(int i=0;i<res.size();i++)
            out.println(res.get(i));
    }
}
