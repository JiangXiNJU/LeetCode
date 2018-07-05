/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
BUG:要记录下相同点的个数，比如 a,a,a,b,c,...3a，与b形成直线，如果不是最佳直线，再向后到c，3a的统计结果就丢了
 */

package LeetCode;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/6/10.
 */
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}

class line{
    Point p1,p2;
    public line(Point _p1,Point _p2){
        p1=_p1;
        p2=_p2;
    }
    public boolean online(Point p){
        if((p.x-p1.x)*(p2.y-p1.y)==(p.y-p1.y)*(p2.x-p1.x)) return true;
        return false;
    }
}

public class max_points_on_a_line {
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int max=2;
        int len=points.length;
        for(int i=0;i<len-1;i++){
            if(len-i+1<=max) break;
            int numsame=0,numline=1;
            for(int j=i+1;j<len;j++) {
                if(points[j].x==points[i].x && points[j].y==points[i].y) numsame++;
                else{
                    line l = new line(points[i], points[j]);
                    numline=2;
                    for (int k = j + 1; k < len; k++) {
                        if (l.online(points[k])) {
                            numline++;
//                            if((i==4&&j==11)||(i==7&&j==11))
//                                out.print(k+" , ");
                        }
                    }
//                    if(tmpmax==24)
//                        out.println("\n"+i + " , " + j + " , " + tmpmax);
                }
                if (numsame+numline > max) max = numsame+numline;
            }
        }
        out.println(max);
        return max;
    }

    public static void main(String[] args){
//        int[][] array={{-230,324},{-291,141},{34,-2},{80,22},{-28,-134},{40,-23},{-72,-149},{0,-17},{32,-32},{-207,
//                288},{7,32},{-5,0},{-161,216},{-48,-122},{-3,39},{-40,-113},{115,-216},{-112,-464},{-72,-149},{-32,-104},{12,42},{-22,19},{-6,-21},{-48,-122},{161,-288},{16,11},{39,23},{39,30},{873,-111}
//    };
        int[][] array={{40,-23},{9,138},{429,115},{50,-17},{-3,80},
                {-10,33},{5,-21},{-3,80},{-6,-65},{-18,26},
                {-6,-65},{5,72},{0,77},{-9,86},{10,-2},
                {-8,85},{21,130},{18,-6},{-18,26},{-1,-15},
                {10,-2},{8,69},{-4,63},{0,3},{-4,40},
                {-7,84},{-8,7},{30,154},{16,-5},{6,90},
                {18,-6},{5,77},{-4,77},{7,-13},{-1,-45},{16,-5},{-9,86},{-16,11},{-7,84},{1,76},{3,77},{10,67},{1,-37},{-10,-81},{4,-11},{-20,13},{-10,77},{6,-17},{-27,2},{-10,-81},{10,-1},{-9,1},{-8,43},{2,2},{2,-21},{3,82},{8,-1},{10,-1},{-9,1},{-12,42},{16,-5},{-5,-61},{20,-7},{9,-35},{10,6},{12,106},{5,-21},{-5,82},{6,71},{-15,34},{-10,87},{-14,-12},{12,106},{-5,82},{-46,-45},{-4,63},{16,-5},{4,1},{-3,-53},{0,-17},{9,98},{-18,26},{-9,86},{2,77},{-2,-49},{1,76},{-3,-38},{-8,7},{-17,-37},{5,72},{10,-37},{-4,-57},{-3,-53},{3,74},{-3,-11},{-8,7},{1,88},{-12,42},{1,-37},{2,77},{-6,77},{5,72},{-4,-57},{-18,-33},{-12,42},{-9,86},{2,77},{-8,77},{-3,77},{9,-42},{16,41},{-29,-37},{0,-41},{-21,18},{-27,-34},{0,77},{3,74},{-7,-69},{-21,18},{27,146},{-20,13},{21,130},{-6,-65},{14,-4},{0,3},{9,-5},{6,-29},{-2,73},{-1,-15},{1,76},{-4,77},{6,-29}};
        Point[] points=new Point[array.length];
        for(int i=0;i<array.length;i++)
            points[i]=new Point(array[i][0],array[i][1]);
        max_points_on_a_line s=new max_points_on_a_line();
        s.maxPoints(points);

    }
}
