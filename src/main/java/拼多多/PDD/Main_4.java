package 拼多多.PDD;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_4 {
    public static boolean com(String[] origin,String r ){
        int n=origin.length;
        if(r.compareTo(origin[0])==0||r.compareTo(origin[n-1])==0) return false;
        if(r.compareTo(origin[0])<0||r.compareTo(origin[n-1])>0) return true;
        int f=0,b=n-1;
        while(f<=b){
            int mid=f+(b-f)/2;
            int res=r.compareTo(origin[mid]);
            if(res==0) return false;
            if(res<0) b=mid;
            else f=mid;
        }
        if(r.compareTo(origin[f])==0) return false;
        return true;
    }
    public static char[] find(char[][] tokens,int l,int n,String[] origin,char[] res,int[] index){
//        out.println("res: "+new String(res));
        if(com(origin,new String(res))==true) return res;
        int i=l-1;
        for(;i>=0;i--){
            if(index[i]==n-1){
                index[i]=(index[i]+1)%n;
                res[i]=tokens[i][index[i]];
            }
            else{
                index[i]=(index[i]+1)%n;
                res[i]=tokens[i][index[i]];
                break;
            }
        }
        if(i==-1) return null;
        return find(tokens, l, n, origin, res, index);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),l=scan.nextInt();
        scan.nextLine();
        String[] words=new String[n];
        for(int i=0;i<n;i++)
            words[i]=scan.nextLine();
        char[][] tokens=new char[l][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<l;j++)
                tokens[j][i]=words[i].charAt(j);
        }
        for(int i=0;i<l;i++)
            Arrays.sort(tokens[i]);
        Arrays.sort(words);

        char[] res=new char[l];
        int[] index=new int[l];
        for(int i=0;i<l;i++)
            res[i]=tokens[i][0];
        res=find(tokens,l,n,words,res,index);
        if(res==null) out.println("-");
        else out.println(new String(res));
    }
}
