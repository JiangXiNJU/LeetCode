package Tecent;

/**
 * Created by cycy on 2018/9/16.
 */

import java.util.*;

import static java.lang.System.out;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),m=scan.nextInt();
        int[][] road=new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int u=scan.nextInt(),v=scan.nextInt();
            road[u][v]=1;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(road[i][k]==1&&road[k][j]==1){
                        road[i][j]=1;
                    }
                }
            }
        }

        int ans=0;
        int[] in=new int[n+1],ou=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                ou[i]+=road[i][j];
                in[i]+=road[j][i];
            }
        }
        for(int i=1;i<=n;i++){
            if(in[i]>ou[i]) ans++;
        }
        out.println(ans);
    }
}
