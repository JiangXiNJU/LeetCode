package FX;

/**
 * JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式，易于阅读和编写。在网络设备中应用广泛。
 JSON用于描述数据结构，有以下形式存在。
 1，对象（object）：一个对象以{开始，并以}结束。一个对象包含一系列非排序的名称／值对，每个名称／值对之间使用,分区。
 2，名称／值（collection）：名称和值之间使用：隔开，一般的形式是：{name:value}
 3，一个名称是一个字符串； 一个值可以是一个字符串，一个数值，一个对象，一个布尔值，一个有序列表，或者一个null值。
 4，值的有序列表（Array）：一个或者多个值用,分区后，使用[，]括起来就形成了这样的列表，形如：[collection, collection]
 5，字符串：以""括起来的一串字符。
 6，数值：一系列0-9的数字组合，可以为负数或者小数。还可以用e或者E表示为指数形式。
 7，布尔值：表示为true或者false。
 本题要求实现简易的json解析功能，输入为给定json字符串和一个需要获取“名称／值”对中的名称，输出为“名称／值”对中的值
 为简化处理，有如下约束：
 1，不用支持boolea类型
 2，不用考虑名称重复，也就是找到即可
 3，不考虑值为object或者array的场景
 输入描述:
 输入为给定json字符串和一个需要获取“名称／值”对中的名称，json字符串下面空一行，然后输入第二个参数
 输出描述:
 输出为“名称／值”对中的值
 示例1
 输入

 {"text":"This is the text",
 "color":"dark_red",
 "bold":"true",
 "strikethough":"true"}

 bold
 输出

 true
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static boolean find(String str,String target){
//        out.println(str+" to find "+target);
//        out.println(str+ " contains \"bold\" : "+str.contains(target));
        if(!str.contains(target)) return false;
        else{
//            out.println("contains");
            if(str.contains(":")){
//                out.println("contains");
                String[] str2=str.split(":");
                char[] val=str2[1].toCharArray();
//                out.println("val"+str2[1]);
                if(str2[1].contains("\"")){
                    String res=(str2[1].split("\""))[1];
                    out.print(res);
                }
                else{
                    String res=str2[1].trim();
                    out.print(res);
                }
            }
            else {
                out.print("null");
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str0="";
        while(scan.hasNext()){
            String str=scan.nextLine();
//           out.println(str);
            if(str.equals("")) break;
            str0+=str;
        }
        String target=scan.nextLine();

        String[] strs=str0.split(",");
//        out.println(str0);
//        out.println(target);
//        for(int i=0;i<strs.length;i++)
//            out.println(strs[i]);
        boolean flag=false;
        for(int i=0;i<strs.length;i++){
            flag=find(strs[i],target);
            if(flag){
                out.println();
                break;
            }
        }
        if(!flag) out.println("null");
    }
}
