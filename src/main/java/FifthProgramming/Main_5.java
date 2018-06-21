package FifthProgramming;

/**
 * Created by cycy on 2018/6/20.
 * 牛牛在地上捡到了一个手套，他带上手套发现眼前出现了很多个小人，当他打一下响指，这些小人的数量就会发生以下变化：如果小人原本的数量是偶数那么数量就会变成一半，如果小人原本的数量是奇数那么数量就会加一。现在牛牛想考考你，他要打多少次响指，才能让小人的数量变成1。
 输入描述:
 每个输入包含一个测试用例。
 输入的第一行包括一个正整数，表示一开始小人的数量N(1<=N<=10^100)。


 输出描述:
 对于每个用例，在单独的一行中输出牛牛需要打多少次响指才能让小人的数量变成1。

 输入例子1:
 10000

 输出例子1:
 20
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Main_5 {
    public static String makeString(int len){
        StringBuffer str=new StringBuffer();
        for(int i=0;i<len;i++)
            str.append("9");
        return str.toString();
    }
    public static boolean isOne(char[] nums,int len){
        for(int i=0;i<len-1;i++) {
            if (nums[i] != '0') return false;
        }
        if(nums[len-1]!='1') return false;
        return true;
    }
    public static void divide2(char[] nums,int len){
        int act=0;
        int index=0;
        while(index<len){
            int num=nums[index]-'0';
            if(act==0){
                nums[index]=(char)(num/2+'0');
                act=num%2;
            }
            else {
                num+=10;
                nums[index]=(char)(num/2+'0');
                act=num%2;
            }
            index++;
        }
    }
    public static void add1(char[] nums,int len){
        int act=0;
        if(nums[len-1]!='9') nums[len-1]+=1;
        else {
            act=1;
            int index=len-1;
            while (act!=0){
                if(nums[index]=='9'){
                    nums[index]='0';
                    act=1;
                    index--;
                }
                else{
                    nums[index]+=1;
                    act=0;
                }
            }
        }
    }
    public static boolean isEven(char[] nums,int len){
        int num=nums[len-1]-'0';
        return num%2==0?true:false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sum=scan.nextLine();
        char[] nums=new char[105];
        int time=0;
        int len=sum.length();
        if(makeString(len).equals(sum)){
            len++;
            nums[0]='1';
            for(int i=1;i<len;i++)
                nums[i]='0';
            time++;
        }
        else{
            for(int i=0;i<len;i++)
                nums[i]=sum.charAt(i);
        }
        while(! isOne(nums,len)){
            time++;
            if(isEven(nums,len)) {
//                out.println(new String(nums)+" is even");
                divide2(nums,len);
            }
            else {
//                out.println(new String(nums)+" is odd");
                add1(nums,len);
            }
//            out.println(nums);
        }
        out.println(time);
    }
}
