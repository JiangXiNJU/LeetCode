package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words,
 the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.

 Example 1:

 Input:
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 maxWidth = 16
 Output:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Example 2:

 Input:
 words = ["What","must","be","acknowledgment","shall","be"]
 maxWidth = 16
 Output:
 [
 "What   must   be",
 "acknowledgment  ",
 "shall be        "
 ]
 Explanation: Note that the last line is "shall be    " instead of "shall     be",
 because the last line must be left-justified instead of fully-justified.
 Note that the second line is also left-justified becase it contains only one word.
 Example 3:

 Input:
 words = ["Science","is","what","we","understand","well","enough","to","explain",
 "to","a","computer.","Art","is","everything","else","we","do"]
 maxWidth = 20
 Output:
 [
 "Science  is  what we",
 "understand      well",
 "enough to explain to",
 "a  computer.  Art is",
 "everything  else  we",
 "do                  "
 ]
 */
public class Solution68_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<String>();
        int index_w=0;
        while(index_w<words.length){
            int start=index_w;
            int len=words[index_w++].length();
            int len_words=len;
            while(index_w<words.length&&len<=maxWidth){
                len_words+=words[index_w].length();
                len+=1+words[index_w++].length();
            }
            if(len<=maxWidth){//最后一行
                StringBuilder sb=new StringBuilder(maxWidth);
                sb.append(words[start]);
                int remain_len=maxWidth-words[start].length();
                for(int i=start+1;i<words.length;i++){
                    sb.append(' ');
                    sb.append(words[i]);
                    remain_len-=1+words[i].length();
                }
                append_space(sb,remain_len);
                res.add(sb.toString());
            }
            else{
                len_words-=words[--index_w].length();
                int len_space=maxWidth-len_words;
                int end=(index_w)-1;
                int num_slot=end-start;
                if(num_slot==0){
                    StringBuilder sb=new StringBuilder(maxWidth);
                    sb.append(words[start]);
                    append_space(sb,len_space);
                    res.add(sb.toString());
                }
                else {
                    int baselen_space = len_space / num_slot;
                    int extralen_space =len_space%num_slot;
                    StringBuilder sb=new StringBuilder(maxWidth);
                    for(int i=start,j=0;i<end;i++){
                        sb.append(words[i]);
                        if(j<extralen_space){
                            j++;
                            append_space(sb,baselen_space+1);
                        }
                        else append_space(sb,baselen_space);
                    }
                    if(end>start) sb.append(words[end]);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
    public void append_space(StringBuilder sb,int num){
        char[] space=new char[num];
        for(int i=0;i<num;i++)
            space[i]=' ';
        sb.append(space);
    }
}
