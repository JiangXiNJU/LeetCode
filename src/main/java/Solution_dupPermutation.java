import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/12.
 */
public class Solution_dupPermutation {
    public void sortarray(char[] chars,int f,int b){
        if(f>=b) return;
        Arrays.sort(chars,f,b+1);
    }
    public ArrayList<String> Permutation(String str) {
        Scanner scan=new Scanner(System.in);
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res=new ArrayList<String>();
        if(str.equals("")) return res;
        res.add(new String(chars));
        while(true){
            int index=chars.length-2;
            while(index>=0&&chars[index]>=chars[index+1]) index--;
            if(index<0) break;
            int index_b=index+1;
            char min=chars[index_b];
            for(int i=index_b+1;i<chars.length;i++){
                if(chars[i]<min&&chars[i]>chars[index]){
                    min=chars[i];
                    index_b=i;
                }
            }
            chars[index_b]=chars[index];
            chars[index]=min;
            sortarray(chars,index+1,chars.length-1);
            String mid=new String(chars);
            out.println(mid);
            res.add(mid);
//            scan.next();
        }
        return res;
    }
    public static void main(String[] args){
        Solution_dupPermutation s=new Solution_dupPermutation();
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        s.Permutation(str);

    }
}