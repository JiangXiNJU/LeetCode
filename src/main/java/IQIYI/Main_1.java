package IQIYI;

/**
 * Created by cycy on 2018/9/28.
 */
import java.util.*;
import static java.lang.System.out;

public class Main_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        Arrays.sort(a);
        int max_len=0;
        int cur=a[0];
        int tmp_len=1;
        int index=1;
        while(index<n){
            if(a[index]==cur) tmp_len++;
            else{
                if(tmp_len>max_len) max_len=tmp_len;
                tmp_len=1;
                cur=a[index];
            }
            index++;
        }
        if(tmp_len>max_len) max_len=tmp_len;
        out.println(max_len);
    }
}