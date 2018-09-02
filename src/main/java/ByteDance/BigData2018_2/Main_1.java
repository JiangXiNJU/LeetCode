package ByteDance.BigData2018_2;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/b724742971d144e4be9a96a7737ad414
 来源：牛客网

 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。


 输入描述:

 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型


 输出描述:

 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 示例1
 输入

 5
 1 2 3 3 5
 3
 1 2 1
 2 4 5
 3 5 3
 输出

 1
 0
 2
 说明

 样例解释:
 有5个用户，喜好值为分别为1、2、3、3、5，
 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 */
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scan.nextInt();
        int delta=1000;
        HashMap<Integer,Integer>[] data=new HashMap[n%delta==0?n/delta:n/delta+1];
        for(int i=0;i<data.length;i++)
            data[i]=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            int pos=i/delta;
            if(data[pos].containsKey(nums[i])){
                int origin=data[pos].get(nums[i]);
                data[pos].put(nums[i],origin+1);
            }
            else data[pos].put(nums[i],1);
        }
        
        int q=scan.nextInt();
        for(int i=0;i<q;i++){
            int l=scan.nextInt()-1,r=scan.nextInt()-1,k=scan.nextInt();
            int sum=0;
            int start=l/delta+1;
            int end=r/delta-1;
            for(int j=start;j<=end;j++){
                if(data[j].containsKey(k)) sum+=data[j].get(k);
            }
//            out.print("整数区间内: "+sum);
            for(int j=l;j<(l/delta+1)*delta&&j<=r;j++){
                if(nums[j]==k) sum++;
            }
            if(r/delta>l/delta){
                for(int j=r/delta*delta;j<=r;j++){
                    if(nums[j]==k) sum++;
                }
            }
            out.println(sum);
        }
//        out.println();
    }
}
