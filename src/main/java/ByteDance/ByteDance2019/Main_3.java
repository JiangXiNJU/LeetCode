package ByteDance.ByteDance2019;

/**
 * Created by cycy on 2018/8/25.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static String move(String str){
        char[] ch=str.toCharArray();
        char tmp=ch[0];
        for(int i=1;i<ch.length;i++)
            ch[i-1]=ch[i];
        ch[ch.length-1]=tmp;
        return new String(ch);
    }
    public static String reverse(String str){
        char[] ch=str.toCharArray();
        for(int i=0;i<(ch.length+1)/2;i++){
            char tmp=ch[i];
            ch[i]=ch[ch.length-i-1];
            ch[ch.length-i-1]=tmp;
        }
        return new String(ch);
    }
    public static String[] getset(String str){
        int len=str.length();
        String[] res=new String[len*2];
        res[0]=str;
        for(int i=1;i<len;i++)
            res[i]=move(res[i-1]);
        res[len]=reverse(str);
        for(int i=len+1;i<len*2;i++)
            res[i]=move(res[i-1]);
        Arrays.sort(res, new Comparator<String>() {
            public int compare(String o1, String o2) {
                for(int i=0;i<o1.s)
            }
        });
        return res;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        for(int T=1;T<=t;T++){
            int n=scan.nextInt();
//            out.println(n);
            scan.nextLine();
            String[] strs=new String[n];
            for(int i=0;i<n;i++)
                strs[i]=scan.nextLine();
            boolean notfind=true;
            for(int i=0;i<n-1&&notfind;i++){
                String[] set=getset(strs[i]);
                for(int j=i+1;j<n&&notfind;j++){
                    for(int k=0;k<set.length&&notfind;k++){
                        if(strs[j].equals(set[k]))
                            notfind=false;
                    }
                }
            }
            if(!notfind) out.println("Yeah");
            else out.println("Sad");
        }
    }
}

/**
 *
 */
