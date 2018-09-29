package 阿里巴巴;

/**
 * Created by cycy on 2018/9/7.
 */
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            out.println(1);
        }
        else {
            int[][] dp = new int[n + 1][2];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            dp[0][0] = 1;
            dp[1][1] = 1;
            dp[2][0] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i][1] = dp[i - 1][0];
                dp[i][0] = dp[i - 2][0] + dp[i - 2][1] + dp[i - 3][0] + dp[i - 3][1];
            }
            out.println(dp[n][0] + dp[n][1]);
        }
    }
}

