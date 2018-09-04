package 常用算法;

/**
 * Created by cycy on 2018/9/2.
 */
import Util.Print;

import java.util.ArrayList;

import static java.lang.System.out;
public class Permutation {
    public static void swap(int[] a,int f,int b){
        int tmp=a[f];
        a[f]=a[b];
        a[b]=tmp;
    }

    /**
     * 递归全排列,若有重复字符，会冗余
     * permutation_recur(a,0)
     * @param a
     * @param s
     */
    public static void permutation_recur(int[] a,int s){

        if(s==a.length-1) Print.Print_IntArray(a,0,a.length-1);
        else {
            for (int j = s; j < a.length; j++) {
                swap(a, s, j);
                permutation_recur(a, s + 1);
                swap(a, s, j);
            }
        }
    }

    public static void permutation_norecur(int[] a){
        //见Next_Permutation
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4};
        permutation_recur(a,0);
    }
}
