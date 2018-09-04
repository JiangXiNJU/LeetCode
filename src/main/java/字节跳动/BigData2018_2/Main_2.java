package 字节跳动.BigData2018_2;

/**
 * Created by cycy on 2018/8/21.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;

public class  Main_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),m=scan.nextInt(),c=scan.nextInt();
        ArrayList<Integer>[] color=new ArrayList[n];
        for(int i=0;i<n;i++){
            int col=scan.nextInt();
            color[i]=new ArrayList<Integer>(col);
            for(int j=0;j<col;j++)
                color[i].add(scan.nextInt());
        }

        Set<Integer> find=new HashSet<Integer>(c);

        for(int i=0;i<n;i++){
            int[] color_tmp=new int[c];
            for(int j=0;j<m;j++){
                for(Integer cc:color[(j+i)%n]){
                    color_tmp[cc-1]++;
                }
            }
            for(int j=0;j<c;j++){
                if(color_tmp[j]>=2)
                    find.add(j);
            }
        }
        out.println(find.size());
    }
}
