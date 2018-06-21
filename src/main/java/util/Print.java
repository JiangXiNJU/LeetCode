package util;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/18.
 */
public class Print {
    public static void Print_Array(int [] array,int f,int b){
        for(int i=f;i<=b;i++)
            out.print(array[i]+" ");
        out.println();
    }
}
