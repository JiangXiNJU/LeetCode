package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        if(strs.length==1) return strs[0];

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String str1=strs[0],str2=strs[strs.length-1];
        int same=0;
        for(int i=0;i<str1.length()&&i<str2.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) break;
            same++;
        }
        return str1.substring(0,same);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

    }
}
