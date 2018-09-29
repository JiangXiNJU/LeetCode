package 常用算法.图计算.最短路径;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/9/2.
 */
public class Dijkstra {
    public static int find_min_dis(int[] t_arc,int t,HashMap<Integer,Integer> distance){
        int min=Integer.MAX_VALUE,min_index=0;
        for(int i=0;i<t_arc.length;i++){
            if(min_index!=t&&distance.containsKey(i)==false&&t_arc[i]>=0&&t_arc[i]<min){//<0说明不可达
                min=t_arc[i];
                min_index=i;
            }
        }
        return min_index;
    }
    public static int dijkstra(int[][] arc,int s,int t){
        int n=arc.length;
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        distance[s]=0;
        Set<Integer> already_find=new HashSet<Integer>(n);
        already_find.add(s);
        int new_find=s;
        while(already_find.size()<n&&new_find!=t){
            int front_dis=distance[new_find];
            int min_dis=Integer.MAX_VALUE,min_index=-1;
            for(int i=0;i<n;i++){
                if(arc[new_find][i]<0) continue;
                int dis=arc[new_find][i]+front_dis;
                if(distance[i]<0||dis<distance[i]){
                    distance[i]=dis;

                }
                else dis=distance[i];
                if(dis<min_dis){
                    min_dis=dis;
                    min_index=i;
                }
            }
            already_find.add(min_index);
            new_find=min_index;
        }
        return distance[t];
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<Integer>();
        out.println(set.contains(null));
    }
}
