import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/3/25.
 * 从1-9中选择k个数，使和为n
 */
public class Main_combine {
    public static int min_from_there(int m,int k){
        return (m*2+k-1)*k/2;
    }
    public static int max_from_there(int m,int k){
        return m+(9+9-k+2)*(k-1)/2;
    }
    public static List<int[]> get(int start,int sum,int k){
        List<int[]> res=new ArrayList<int[]>();
        if(k==1){
            if(sum>=start&&sum<=9) {
                int[] ele = {sum};
                res.add(ele);
            }
            else return res;
        }
            else{
                for(int i=start;i<=9-k+1;i++){
                    if(min_from_there(i,k)>sum) break;
                    if(max_from_there(i,k)<sum) continue;
                    List<int[]> i_res=get(i+1,sum-i,k-1);
                    if(i_res.size()>0){
                        for(int[] j:i_res){
                            int[] ele=new int[k];
                            ele[0]=i;
                            System.arraycopy(j,0,ele,1,j.length);
                            res.add(ele);
                        }
                    }
                }
            }
        return res;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int k=scan.nextInt();
        int n=scan.nextInt();
        if(k==1&&n<=9&&n>=1) out.println(n);
        else if(k>=10||n<min_from_there(1,k)||n>max_from_there(9-k+1,k)) {
//            out.println("invalid input");
            out.println("None");
        }
        else{
            List<int[]> res=get(1,n,k);
            if(res.size()>0){
                for(int[] i:res){
                   out.print(i[0]);
                    for(int j=1;j<i.length;j++){
                        out.print(" "+i[j]);
                    }
                    out.println();
                }
            }
            else out.println("None");
        }
    }
}
