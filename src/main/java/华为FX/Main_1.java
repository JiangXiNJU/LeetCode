package 华为FX;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * 题目描述
 小明手上有两幅扑克牌a和b，花色不论，且排好了顺序
 现在需要从a和b中各自抽走尽可能少的扑克牌，使得a和b剩余的牌和顺序完全相同
 请计算出所有可能剩余的牌的序列的个数
 输入描述:
 两幅扑克牌序列a和b
 输出描述:
 抽掉尽可能少的扑克牌后，所有可能剩余的牌序列的个数
 示例1
 输入

 126AJ
 126
 输出

 1
 说明

 有一个剩余牌序列：126
 示例2
 输入

 1234
 2143
 输出

 4
 说明

 有4个剩余牌序列：13 / 14 / 23 / 24
 示例3
 输入

 ABC
 输出

 none
 说明

 扑克牌里没有ABC，只有123456789JQK，所以输出none
 备注:
 扑克牌为123456789JQK 之一，如果出现其他字符，输出“none”
 */
public class Main_1 {

    public static boolean judgech(char ch){
        return ch>='0'&&ch<='9' || ch=='J'||ch=='Q'||ch=='K';
    }
    public static boolean judge(char[] ch){
        int len=ch.length;
        int index=0;
        while(index<len){
            if(judgech(ch[index])==false) {
//                out.println("ch w");
                return false;
            }
            index++;
        }
        return true;
    }

    public static int find(char[] a0,char[] b0){
        return 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println();
        char[] a=scan.nextLine().toCharArray();
        char[] b=scan.nextLine().toCharArray();
        if( ! judge(a) || ! judge(b)) out.println("none");
        else{
            int res=find(a,b);
//            if(res<=0) out.println("none");
//            else
//            out.println(res);
        }
    }
}