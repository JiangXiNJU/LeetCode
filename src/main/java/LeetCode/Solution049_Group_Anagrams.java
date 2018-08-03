package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.

 */
public class Solution049_Group_Anagrams {
    public int comp(String a,String b){
        if(a.length()!=b.length()){
            if(a.length()<b.length()) return -1;
            else return 1;
        }
        char[] a_c=new char[26];
        char[] b_c=new char[26];
       for(int i=0;i<a.length();i++){
           a_c[a.charAt(i)-'a']++;
           b_c[b.charAt(i)-'a']++;
       }
       for(int i=0;i<26;i++){
           if(a_c[i]<b_c[i]) return -1;
           if (a_c[i] > b_c[i]) return 1;
       }
        return 0;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res=new ArrayList<List<String>>();
        if(strs==null||strs.length==0) return res;
        /**
         * 排序做法,较快
         */
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return comp(o1,o2);
            }
        });
        ArrayList<String> res0=new ArrayList<String>();
        res0.add(strs[0]);
        ArrayList<String> cur_res=res0;
        for(int i=1;i<strs.length;i++){
            if(comp(strs[i-1],strs[i])==0)
                cur_res.add(strs[i]);
            else{
                res.add(cur_res);
                cur_res=new ArrayList<String>();
                cur_res.add(strs[i]);
            }
        }
        res.add(cur_res);

        /**
         * 直接添加
         */
//        ArrayList<String> res0=new ArrayList<String>();
//        res0.add(strs[0]);
//        res.add(res0);
//        for(int i=1;i<strs.length;i++){
//            boolean find=false;
//            for(int j=0;j<res.size();j++){
//                String b=res.get(j).get(0);
//                if(comp(strs[i],b)==0) {
//                    res.get(j).add(strs[i]);
//                    find=true;
//                    break;
//                }
//            }
//            if(!find){
//                ArrayList<String> res_t=new ArrayList<String>();
//                res_t.add(strs[i]);
//                res.add(res_t);
//            }
//        }
        return res;
    }
}
