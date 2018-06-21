package Sword2Offer;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/18.
 */
public class Solution_Add {
    public int Add(int num1,int num2) {
        int cnt=(num1&num2)<<1;
        int sum=num1^num2;
        while(cnt!=0){
            int pre_cnt=cnt;
            cnt=(pre_cnt&sum)<<1;
            sum=sum^pre_cnt;
        }
        return sum;
    }
    public static void main(String[] args){
        Solution_Add s=new Solution_Add();
        int sum=s.Add(10,11);
        out.println(sum);
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            out.println(Integer.parseInt(str));
        }
    }
}
