import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/6/20.
 * <p>
 * Created by cycy on 2018/4/6.
 */
/**
 * Created by cycy on 2018/4/6.
 */

public class Main_ReOrder {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        out.println();
        String[] array={"3334","3","333332"};
        Arrays.sort(array,new Comparator<String>(){
            public int compare(String s1,String s2){
                char head1=s1.charAt(0);
                char head2=s2.charAt(0);
                int index1=0;
                int index2=0;
                while(index1<s1.length()&&index2<s2.length()){
                    if(s1.charAt(index1)>s2.charAt(index2)) return 1;
                    else if(s1.charAt(index1)<s2.charAt(index2)) return -1;
                    index1++;
                    index2++;
                }
                if(index1==s1.length()){
                    while(index2<s2.length()){
                        if(s2.charAt(index2)<head1) return 1;
                        else if(s2.charAt(index2)>head1) return -1;
                        index2++;
                    }
                }
                else{
                    while(index1<s1.length()){
                        if(s1.charAt(index1)>head2) return 1;
                        else if(s1.charAt(index1)<head2) return -1;
                        index1++;
                    }
                }
                return 1;
            }
        });
        for(int i=0;i<array.length;i++)
            out.println(array[i]);
    }
}
