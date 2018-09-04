package 拼多多;

/**
 * Created by cycy on 2018/7/22.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static String method(String s){
        if(s.length()<=1) return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)) return s.substring(0,1);
            return s;
        }
        char[]s_c=s.toCharArray();
        StringBuffer p_tmp=new StringBuffer();
        p_tmp.append(s_c[0]);
        int p_start=0;
        int next_front=1;
        for(int i=1;i<s_c.length;i++){
            if(s_c[i]==p_tmp.charAt(p_start)){
                p_start=(p_start+1)%p_tmp.length();
            }
            else{
                p_tmp.append((s.substring(next_front,i+1)).toCharArray());
                p_start=0;
                next_front=i+1;
            }
        }
        return p_tmp.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S=scan.nextLine();
        out.println(method(S));
    }
}
