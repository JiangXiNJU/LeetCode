package 常用算法.图计算.最短路径;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * spfa的算法思想（动态逼近法）：
 设立一个先进先出的队列q用来保存待优化的结点，
 优化时每次取出队首结点u，并且用u点当前的最短路径估计值对离开u点所指向的结点v进行松弛操作，
 如果v点的最短路径估计值有所调整，且v点不在当前的队列中，就将v点放入队尾。这样不断从队列中取出结点来进行松弛操作，直至队列空为止。

 松弛操作的原理是著名的定理：“三角形两边之和大于第三边”，在信息学中我们叫它三角不等式。
 所谓对结点i,j进行松弛，就是判定是否dis[j]>dis[i]+w[i,j]，如果该式成立则将dis[j]减小到dis[i]+w[i,j]，否则不动。

 SPFA无法处理带负环的图
 */
public class SPFA {
    static int n;
    static ArrayList<int[]>[] adjacent=new ArrayList[n];
    public static int spfa(int s,int t){
        int distance[]=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[s]=0;
        boolean visit[]=new boolean[n];
        Arrays.fill(visit,false);
        Queue<Integer> queue=new LinkedList<Integer>();

        queue.offer(s);
        visit[s]=true;
        while(!queue.isEmpty()){
            int start=queue.poll();
            visit[start]=false;
            for(int[] i:adjacent[start]){
                int end=i[0];
                int dis=i[1];
                if(distance[start]+dis<distance[end]){
                    distance[end]=distance[start]+dis;
                    queue.offer(end);
                    visit[end]=true;
                }
            }
        }
        return distance[t];
    }
}
