package LeetCode;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hashtable=new boolean[128];
        char[] chars=s.toCharArray();
        if(chars.length<2) return chars.length;
        for(int i=0;i<128;i++)
            hashtable[i]=false;
        int max=1;
        int front=0;
        hashtable[chars[front]]=true;
        int back=1;
        int tmp_len=1;
        while(back<chars.length){
            if(hashtable[chars[back]]==false){
                tmp_len++;
                hashtable[chars[back]]=true;
            }
            else{
                if(tmp_len>max) max=tmp_len;
                for(int i=front;i<back;i++){
                    if(chars[i]==chars[back]){
                        tmp_len-=i-front;
                        front=i+1;
                        break;
                    }
                    else hashtable[chars[i]]=false;
                }
            }
            back++;
        }
        if(tmp_len>max) max=tmp_len;
        return max;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        Solution003_Longest_Substring_Without_Repeating_Characters c=new Solution003_Longest_Substring_Without_Repeating_Characters();
        out.println(c.lengthOfLongestSubstring(s));
    }
}
