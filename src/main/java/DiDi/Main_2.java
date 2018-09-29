package DiDi;

/**
 * Created by cycy on 2018/9/18.
 */

import java.util.*;
import static java.lang.System.out;

public class Main_2 {

    static class road{
        int x1,y1,x2,y2;
        int a,b,c;
        int xl,xr,yl,yr;
        road(int _x1,int _y1,int _x2,int _y2){
            x1=_x1;
            y1=_y1;
            x2=_x2;
            y2=_y2;
            if(x1==x2){a=1;b=0;c=x1;}
            else if(y1==y2){a=0;b=1;c=y1;}
            else{
                a=y2-y1;
                b=x1-x2;
                c=a*x1+b*y1;
            }
            if(x1<x2){
                xl=x1;
                xr=x2;
            }
            else{
                xl=x2;
                xr=x1;
            }
            if(y1<y2){
                yl=y1;
                yr=y2;
            }
            else{
                yl=y2;
                yr=y1;
            }
        }
    }

    public static double[] getPoint(road r1,road r2){
        double b=(r1.c-r2.c)/(r1.a-r2.a),k=(r1.b-r2.b)/(r1.a-r2.a);
        double y=(r1.c-r1.a*b)/(r1.b-r1.a*k);
        double x=b-k*y;
        double res[]=new double[2];
        res[0]=x;res[1]=y;
        return res;
    }
    public static boolean judgeOn(road r,double[] point){
        double x=point[0],y=point[1];
        if(x>=r.xl&&x<=r.xr&&y>=r.yl&&y<=r.yr) return true;
        return false;
    }
    public boolean join(road r1,road r2){
        if(r1.xr<r2.xl||r1.xl>r2.xr||r1.yr<r2.yl||r1.yl>r2.yr) return false;
        if(r1.a*r2.b==r1.b*r2.a) return false;//平行

        double []point=getPoint(r1,r2);
        if(judgeOn(r1,point)&&judgeOn(r2,point)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T=scan.nextInt();
        for(int t=0;t<T;t++){
            int n=scan.nextInt();
            HashMap<Integer,ArrayList<road>> region=new HashMap<Integer, ArrayList<road>>();
            ArrayList<road> rs=new ArrayList<road>();
            for(int i=0;i<n;i++){
                String q=scan.next();
                if(q.equals("T")){
                    rs.add(new road(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
                }
                else{
                    int road_index=scan.nextInt();
                    road road0=rs.get(road_index);
                    for(int j=0;j<region.size();j++){
//                        if(region.)
                    }
                }

            }
            out.println();
        }

    }
}
