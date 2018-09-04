package 剑指OFFER;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/4/2.
 */
public class Solution_replace_space {
    public static String replaceSpace(StringBuffer str) {
        if(str==null||str.equals("")) return "";
//        out.println("begin");
        int space_num=0;
        int index=0;
        while(index<str.length()){
            if(str.charAt(index)==' ') space_num++;
            index++;
        }
        int sum=space_num*3+str.length()-space_num;
//        out.println("sum "+sum);
        char[] new_str=new char[sum];
        index=str.length()-1;
        int index_new_str=sum-1;
        while(index>=0){
            if(str.charAt(index)==' '){
                new_str[index_new_str]='0';
                new_str[index_new_str-1]='2';
                new_str[index_new_str-2]='%';
                index_new_str-=3;
            }
            else{
                new_str[index_new_str]=str.charAt(index);
                index_new_str--;
            }
            index--;
        }
        String res=new String(new_str);
        return res;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        out.println(str);
        StringBuffer origin=new StringBuffer(str);
        String res=replaceSpace(origin);
        out.println(res);

    }
}
