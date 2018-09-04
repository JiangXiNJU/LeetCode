package 华为FX;

/**
 * IPv6地址的长度为128位，RFC1884规定的标准语法建议把IPv6地址写成8个16位的无符号整数，每个整数用四个十六进制位表示，这些数之间用冒号（:）分开，例如：
 3ffe:3201:1401:1:280:c8ff:fe4d:db39
 为了进一步简化IPv6的地址表示，只要保证数值不变，就可以将前面的0省略。比如：
 1080:0000:0000:0000:0008:0800:200C:417A
 0000:0000:0000:0000:0000:0000:0A00:0001
 可以简写为：
 1080:0:0:0:8:800:200C:417A
 0:0:0:0:0:0:A00:1
 另外，还规定可以用符号::表示一系列的0。那么上面的地址又可以简化为：
 1080::0:8:800:200C:417A
 ::A00:1
 但是::在一个地址中只能出现一次。
 现在需要编写一个程序，将简化的IPv6地址展开为完整的写法。
 输入描述:
 一个字符串，用来表示一个简化、部分简化或者完整的IPv6地址；注意输入中的16进制数可能混用大写和小写的英文字母，这种做法是合法的
 输出描述:
 将输入IPv6地址展开后的完整IPv6字符串，其中英文字母大写；如果输入字符串有误，则输出Error
 示例1
 输入

 1080::8:800:200C:417A
 输出

 1080:0000:0000:0000:0008:0800:200C:417A
 */
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static boolean judgech(char ch){
        return ch>='0'&&ch<='9' || ch>='A'&&ch<='F' || ch==':';
    }
    public static boolean judge(char[] ch){
        int len=ch.length;
        int num_2=0;
        int index=0;
        while(index<len){
            if(judgech(ch[index])==false) {
//                out.println("ch w");
                return false;
            }
            index++;
        }
        index=0;
        while(index<len){
            if(ch[index]==':'){
                if(index>=len-1) {
//                    out.println("以冒号结尾");
                    return false;
                }
                if(ch[index+1]==':'){
//                    if(index+1>=len-1) return false;
                    if(index+2<len&&ch[index+2]==':') return false;
                    if(num_2!=0) return false;
                    num_2=1;
                    index+=2;
                }
                else index+=1;
            }
            else{
                int num_num=0;
                while(index<len&&ch[index]!=':') {
                    num_num++;
                    index++;
                }
                if(num_num>4) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str=scan.nextLine().toUpperCase();
        char[] ch=str.toCharArray();
        if(judge(ch)==false){
            out.println("Error");
        }
        else{
            ArrayList<char[]> add=new ArrayList<char[]>();
            int index_2=8;

            int index=0;
            while(index<ch.length){
                if(index<ch.length-1&&ch[index]==':'&&ch[index+1]==':'){
                    char[] chs={':',':'};
                    add.add(chs);
                    index_2=add.size()-1;
                    index+=2;
                }
                else if(ch[index]==':') index++;
                else{
                    int num_len=0;
                    char[] ch0=new char[4];
                    while(index<ch.length&&ch[index]!=':'){
                        ch0[num_len++]=ch[index];
                        index++;
                    }
                    char[] ch1=new char[num_len];
                    System.arraycopy(ch0,0,ch1,0,num_len);
                    add.add(ch1);
                }
            }

            for(int i=0;i<index_2;i++){
                char[] to=add.get(i);
                int len=to.length;
                for(int j=0;j<4-len;j++)
                    out.print('0');
                for(int j=0;j<len;j++)
                    out.print(to[j]);
                if(i<7) out.print(':');
            }
            int num_before=index_2;
            int num_after=add.size()-index_2-1;
            int num_0=8-num_before-num_after;
            if(index_2==8){
                num_after=num_0=0;
            }
            for(int i=0;i<num_0;i++){
                out.print("0000");
                if((i==num_0-1&&num_after>0)||i<num_0-1){
                    out.print(':');
                }
            }
            for(int i=index_2+1;i<add.size();i++){
                char[] to=add.get(i);
                int len=to.length;
                for(int j=0;j<4-len;j++)
                    out.print('0');
                for(int j=0;j<len;j++)
                    out.print(to[j]);
                if(i<add.size()-1) out.print(':');
            }
            out.println();
        }


    }
}
