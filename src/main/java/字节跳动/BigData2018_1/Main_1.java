package 字节跳动;

/**
 * Created by cycy on 2018/8/19.
 */
import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n=scan.nextInt();
        int[][] point=new int[n][2];
        for(int i=0;i<n;i++){
            point[i]=new int[2];
            point[i][0]=scan.nextInt();
            point[i][1]=scan.nextInt();
        }
        Arrays.sort(point, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0]) return -1;
                else if(o1[0]>o2[0]) return 1;
                else{
                    if(o1[1]<o2[1]) return -1;
                    else if(o1[1]>o2[1]) return 1;
                }
                return 0;
            }
        });
        int index=n-1;
        ArrayList<int[]> res=new ArrayList<int[]>(n);
        res.add(point[index]);
        int maxy=point[index][1];
        index--;
        while(index>=0){
            if(point[index][1]>maxy){
                res.add(point[index]);
                maxy=point[index][1];
            }
            index--;
        }
        for(int i=res.size()-1;i>=0;i--)
            out.println(res.get(i)[0]+" "+res.get(i)[1]);

    }
}
