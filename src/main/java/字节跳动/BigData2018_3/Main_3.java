package 字节跳动.BigData2018_3;

/**
 * Created by cycy on 2018/8/24.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),x=scan.nextInt()-1;
        long[] end=new long[n];
        long min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<n;i++){
            end[i]=scan.nextInt();
            if(end[i]<=min){
                min=end[i];
                min_index=i;
            }
        }

        long circle=min;
        if( x>=min_index){
            for(int i=0;i<=min_index;i++)
                end[i]-=circle;
            for(int i=min_index+1;i<=x;i++)
                end[i]-=circle+1;
            for(int i=x+1;i<n;i++)
                end[i]-=circle;
            end[min_index]=n*circle+x-min_index;
        }
        else{
            int index=x;
            while(index>=0&&end[index]>min) index--;
            if(index==-1){
                for(int i=0;i<=x;i++)
                    end[i]-=circle+1;
                for(int i=x+1;i<=min_index;i++)
                    end[i]-=circle;
                for(int i=min_index+1;i<n;i++)
                    end[i]-=circle+1;
                end[min_index]+=n*circle+n-min_index+x;
            }
            else{
                min_index=index;
                for(int i=0;i<=min_index;i++)
                    end[i]-=circle;
                for(int i=min_index+1;i<=x;i++)
                    end[i]-=circle+1;
                for(int i=x+1;i<n;i++)
                    end[i]-=circle;
                end[min_index]=n*circle+x-min_index;
            }
        }

        for(int i=0;i<n-1;i++)
            out.print(end[i]+" ");
        out.println(end[n-1]);
    }
}
