package 常用算法.图计算.最短路径;

import java.util.*;

/**
 * Created by cycy on 2018/9/2.
 */
public class Floyd {
    static int n;
    static int[][] road=new int [n][n];
    private static void floyd() {
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(road[i][k]+road[k][j]<road[i][j]){
                        road[i][j]=road[i][k]+road[k][j];
                    }
                }
            }
        }
    }
}
