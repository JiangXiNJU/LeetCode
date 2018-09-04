package 常用算法.图计算;

/**
 * 无向图连通分量检测 并查集
 */
public class Union_Find {
    static int MAXN=1000;
    static int[] pre=new int[MAXN];
    public static int find(int x){
        int root=pre[x];
        while(root!=pre[root])
            root=pre[root];
        int node=x,tmp;
        while(pre[node]!=root){
            tmp=pre[node];
            pre[node]=root;
            node=tmp;
        }
        return root;
    }
    public static void union(int x,int y){
        int fx=find(x),fy=find(y);
        if(fx<fy) {
            pre[fy]=fx;
        }
        else pre[fx]=fy;
    }
}
