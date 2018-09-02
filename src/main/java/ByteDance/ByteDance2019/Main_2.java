package ByteDance.ByteDance2019;

/**
 * Created by cycy on 2018/8/25.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    static final int mod=1000000007;
    /**
     * 硬算太复杂
     * 还差m个数，k对括号，能组成多少个
    public static long number_combine(int n){
        long sum=10;
        for(int i=1;i<n;i++){
            sum=((sum%mod)*10)%mod;
        }
        return sum;
    }
    public static long pow_2(int num){
        long sum=1;
        for(int i=1;i<=num;i++){
            sum=((sum%mod)*(2%mod))%mod;
        }
        return sum;
    }
    public static long getseg(int number_len,int number_num){
        if(number_len==1) return 1;
        long sum=0;
        for(int i=1;i<=number_len-number_num-1;i++){
            sum=(sum+getseg(number_len-i,number_num-1)%mod)%mod;
        }
        return sum;
    }
    public static long getnumbers(int number_len,int number_num){
        long sum1=number_combine(number_len);
        long sum2=getseg(number_len,number_num);
        return (sum1*sum2)%mod;
    }
    public static long par_num(int number_num,int par){

    }
    public static long justnumber_symbol(int n){
        if(n==0) return 0;
        long sum=0;
        int max_factor_num=n%2==1?(n+1)/2:n/2;
        for(int num=1;num<=max_factor_num;num++){
            int symbol_len=num-1;
            int number_len=n-symbol_len;

            long symbol_type=pow_2(num-1);
            long number_type=getnumbers(number_len,num);
            sum=(sum%mod+(symbol_type*number_type)%mod)%mod;
        }
        return sum;
    }
     */


    public static long multiply(long a,long b){return (a*b)%mod;}
    public static long add(long a,long b){return (a+b)%mod;}
    public static long result(int n){
        if(n==0) return 0;
        long[] dp=new long[n];
        dp[1]=10;
        dp[2]=100;

        long pow_10=100;
        for(int i=3;i<=n;i++){
            pow_10=multiply(pow_10,10);
            dp[i]=add(pow_10,dp[i]);//pure_num
            dp[i]=add(dp[i],dp[i-2]);//(dp)

        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();

        out.println(result(n));
    }
}
