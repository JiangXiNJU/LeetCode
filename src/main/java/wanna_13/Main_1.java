package wanna_13;

/**
 * 链接：https://www.nowcoder.com/acm/contest/80/A
 来源：牛客网

 又到了打wannafly的时候，许许多多的大佬准备注册小号开始虐场，zzy也不例外，他发现他的电脑的字体有一个特点！某些不同的字符所显示的是一样的！


 满足以下四种情况之一，所显示的字符是一样的
 1、两个字符互为英文字母的大小写
 2、大写的'i'和小写的'l'
 3、大写的'o'和数字'0'
 4、基于前三种情况，三个字符a,b,c，如果a和b显示相同，b和c显示相同，那么a和c显示也是相同的
 珂学家zzy想知道，对于一个他看起来相同的昵称，有多少个看起来一样的昵称
 两个字符串看起來一样当且仅当长度一样且每个对应的位置的字符看起來一样


 输入描述:
 一个字符串，只包含大小写字母和数字
 输出描述:
 共一行一个整数，表示看起来一样的昵称数，由于这个数比较大，所以只要求输出模1e9 + 7意义下的解
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        if(str.equals("")) out.println(1);
        else{
            int sum=1;
            int index=0;
            int mod=1000000007;
            while(index<str.length()){
                char c=str.charAt(index);
                if(c=='i'||c=='I'||c=='l'||c=='L') sum=((((sum % mod)+(sum % mod))%mod+(sum % mod))%mod+(sum % mod))
                        %mod;
                else if(c=='0'||c=='o'||c=='O') sum=(((sum % mod)+(sum % mod))%mod+(sum % mod))%mod;
                else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) sum=((sum % mod)+(sum % mod))%mod;
                index++;
            }
            out.println(sum);

        }

    }
}