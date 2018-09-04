package 牛客网比赛;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/3/23.
 */
public class Main_T95 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str0=scan.nextLine();
        int n=Integer.parseInt(str0.split(" ")[0]);
        long m=Integer.parseInt(str0.split(" ")[1]);
        int[] run=new int[n];
        int[] happy=new int[n];
        String[] str=scan.nextLine().split(" ");
        for(int i=0;i<n;i++)
            run[i]=Integer.parseInt(str[i]);
        str=scan.nextLine().split(" ");
        for(int i=0;i<n;i++)
            happy[i]=Integer.parseInt(str[i]);
        long sum=0;
        int index=0;
        while (index<n&&happy[n-1-index]-run[index]>0){
            sum+=happy[n-1-index]-run[index];
            index++;
        }
        sum+=index/3*m;
        int remain=index%3;
        if(index<n&&remain>0){
            if(remain==1){
                if(index+2<=n&&m+happy[n-1-index]-run[index]+happy[n-2-index]-run[index+1]>0){
                    sum+=m+happy[n-1-index]-run[index]+happy[n-2-index]-run[index+1];
                    index+=2;
                }
            }
            else if(remain==2){
                if(index+1<=n&&m+happy[n-1-index]-run[index]>0){
                    sum+=m+happy[n-1-index]-run[index];
                    index+=1;
                }
            }
        }

        while(index<n){
            if(index+2>=n||index+1>=n) break;
            long diff=m+happy[n-1-index]-run[index];
            diff+=happy[n-index-2]-run[index+1];
            diff+=happy[n-index-3]-run[index+2];
            if(diff<=0) break;
            sum +=diff;
            index+=3;
        }
        out.println(sum);
    }
}
