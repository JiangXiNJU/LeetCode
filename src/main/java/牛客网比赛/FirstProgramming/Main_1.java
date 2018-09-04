package 牛客网比赛.FirstProgramming;

/**
 * Created by cycy on 2018/6/20.
 * [编程题] 密码翻译
 时间限制：1秒
 空间限制：65536K
 在情报传递过程中，为了防止情报被截获，往往需要对情报用一定的方式加密，简单的加密算法虽然不足以完全避免情报被破译，但仍然能防止情报被轻易的识别。我们给出一种最简的的加密方法，对给定的一个字符串，把其中从a-y,A-Y的字母用其后继字母替代，把z和Z用a和A替代，则可得到一个简单的加密字符串。
 输入描述:
 读取这一行字符串，每个字符串长度小于80个字符


 输出描述:
 对于每组数据，输出每行字符串的加密字符串。

 输入例子1:
 Hello! How are you!

 输出例子1:
 Ifmmp! Ipx bsf zpv!
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str=scan.nextLine();
        char[] chars=new char[100];
        int len=str.length();
        for(int i=0;i<len;i++){
            char ch=str.charAt(i);
            if(ch>='a'&&ch<='y') chars[i]=(char) (ch+1);
            else if(ch>='A'&&ch<='Y') chars[i]=(char) (ch+1);
            else if(ch=='Z') chars[i]='A';
            else if(ch=='z') chars[i]='a';
            else chars[i]=ch;
        }
        out.println(new String(chars));
    }
}

