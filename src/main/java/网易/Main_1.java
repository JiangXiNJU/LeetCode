package 网易;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 输入描述:
 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


 输出描述:
 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。

 输入例子1:
 4
 1 2 3 4

 输出例子1:
 4 2 1 3
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        out.println();
        int len=scan.nextInt();
        int[] nums=new int[len];
        int[] b=new int[len];
        for(int i=0;i<len;i++)
            nums[i]=scan.nextInt();
        int start=len%2==0?0:1;
        int j=0;
        for(int i=len-1;i>=0;i=i-2,j++)
            b[j]=nums[i];
        for(int i=start;i<len;i+=2,j++)
            b[j]=nums[i];
        for(int i=0;i<len-1;i++)
            out.print(b[i]+" ");
        out.println(b[len-1]);
    }
}
