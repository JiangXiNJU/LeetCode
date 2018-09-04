package 牛客网比赛.FifthProgramming;

/**
 * Created by cycy on 2018/6/19.
 */
import java.util.*;

import static java.lang.System.out;

public class Main_Express {
    public static boolean find(int[] dis,int t){
        int len=dis.length;
        for(int i=0;i<len;i++){
            if(dis[i]<dis[t-1]) return  false;
        }
        return true;
    }
    public static void updatedis(int[] dis,int node,ArrayList neighbours,Queue q){
        if(neighbours==null) return;
        int len=neighbours.size();
        for(int i=0;i<len;i++){
            int[] value=(int[])neighbours.get(i);
            if(dis[node-1]+value[1]<dis[value[0]-1]){
                dis[value[0]-1]=dis[node-1]+value[1];
                q.offer(value[0]);
            }
        }
    }
    public static void search(int[] dis,int s,int t,Map<Integer,ArrayList> map){
        int m=dis.length;
        for (int i = 0; i < m; i++) dis[i] = Integer.MAX_VALUE;
        dis[s-1] = 0;
        Queue q = new LinkedList();
        q.offer(s);
        while (! q.isEmpty() && ! find(dis,t)) {
            int node=(Integer)q.poll();
            updatedis(dis,node,map.get(node),q);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m, s, t, start_index = 0, sum = 0;
        n = scan.nextInt();
        m = scan.nextInt();
        s = scan.nextInt();
        t = scan.nextInt();
        Map<Integer, ArrayList> map = new HashMap<Integer, ArrayList>();

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int d = scan.nextInt();
            int[] tmp = {v, d};
            if (map.containsKey(u)) {
                ArrayList a = map.get(u);
                a.add(tmp);
                map.put(u, a);
            } else {
                ArrayList a = new ArrayList();
                a.add(tmp);
                map.put(u, a);
            }
        }
        int[] dis_s = new int[m];
        search(dis_s,s,t,map);
        sum+=dis_s[t-1];
        int[] dis_t=new int[m];
        search(dis_t,t,s,map);
        sum+=dis_t[s-1];
        out.println(sum);
    }
}