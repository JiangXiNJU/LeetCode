package 常用算法.图计算.最短路径;

import java.util.Arrays;

/**
 * Created by cycy on 2018/9/2.
 */
public class Bellman_ford {
    static int n;
    static int e;
    static int[][] edges=new int[e][3];

    public static boolean bellman_ford(int s,int t){
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[s]=0;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<e;j++){
                int u=edges[j][0],v=edges[j][1];
                if(distance[v]<distance[u]+edges[j][2])
                    distance[v]=distance[u]+edges[j][2];
            }
        }//每条路径最多包含n-1条边

        for(int j=0;j<e;j++){
            int u=edges[j][0],v=edges[j][1];
            if(distance[v]<distance[u]+edges[j][2])
                return true;//存在负权边
        }
        return false;
    }
}
