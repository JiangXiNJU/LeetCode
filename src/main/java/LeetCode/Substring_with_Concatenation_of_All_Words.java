package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 *
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.

 Example 1:

 Input:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 Output: [0,9]
 Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 The output order does not matter, returning [9,0] is fine too.
 Example 2:

 Input:
 s = "wordgoodstudentgoodword",
 words = ["word","student"]
 Output: []
 */
public class Substring_with_Concatenation_of_All_Words {
    public int binarysearch(String target,String[] words){
        int f=0,b=words.length;
        if(words[f].equals(target)) return f;
        while(f+1<b){
            int mid=(f+b)/2;
            if(words[mid].equals(target)) return mid;
            if(words[mid].compareTo(target)>0) b=mid;
            else f=mid;
        }
        if(words[f].equals(target)) return f;
        return -1;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(s==null||s.length()==0) return res;
        if(words==null||words.length==0||words[0]==null||words[0].length()==0){
//            for(int i=0;i<s.length();i++)
//                res.add(i);
            return res;
        }

        int word_len=words[0].length();
        int word_num=words.length;
        Arrays.sort(words);

        ArrayList<String> single_words0=new ArrayList<String>();
        ArrayList<Integer> standard_time0=new ArrayList<Integer>();
        single_words0.add(words[0]);
        int sum=1;
        for(int i=1;i<word_num;i++){
            if(words[i].equals(words[i-1])) sum++;
            else{
                standard_time0.add(sum);
                sum=1;
                single_words0.add(words[i]);
            }
        }
        standard_time0.add(sum);
        String[] single_words=new String[single_words0.size()];
        int[] standard_time=new int[single_words0.size()];
        for(int i=0;i<single_words0.size();i++){
            single_words[i]=single_words0.get(i);
            standard_time[i]=standard_time0.get(i);
        }
        int[] visit_time=new int[single_words.length];
        Arrays.fill(visit_time,0);
//        for(int i=0;i<single_words.length;i++){
//            out.println(single_words[i]+" "+standard_time[i]);
//        }

        for(int i=0;i<=s.length()-word_len*word_num;i++){
//            out.println("i: "+i);
            Arrays.fill(visit_time,0);
            int index=i;
            while(index<i+word_len*word_num){
                String str=s.substring(index,index+word_len);
                int pos=binarysearch(str,single_words);
//                out.println("pos: "+pos);
                if(pos!=-1&& visit_time[pos]<standard_time[pos]){
                    visit_time[pos]++;
                    index+=word_len;
                }
                else{
                    break;
                }
            }
            if(index==i+word_len*word_num)
                res.add(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

        String str=scan.nextLine();
        int k=scan.nextInt();
        scan.nextLine();
        String [] words=new String[k];
        for(int i=0;i<k;i++)
            words[i]=scan.nextLine();

        ArrayList res=(ArrayList) new Substring_with_Concatenation_of_All_Words().findSubstring(str,words);
        for(int i=0;i<res.size();i++)
            out.print(res.get(i));

    }


}
