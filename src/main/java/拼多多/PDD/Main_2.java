package 拼多多.PDD;

import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),m=scan.nextInt();
        char[][] board=new char[n][m];
        scan.nextLine();
        for(int i=0;i<n;i++){
            board[i]=scan.nextLine().toCharArray();
        }
        for(int i=0;i<m;i++){
            int h=0;
            int wood=0;
            while(h<n){
                while(h<n&&board[h][i]!='x'){
                    if(board[h][i]=='o') {
                        board[h][i]='.';
                        wood++;
                    }
                    h++;
                }
                if(h<n){
                    for(int j=1;j<=wood;j++)
                        board[h-j][i]='o';
                    wood=0;
                    h++;
                }
            }
        }
        for(int i=0;i<n;i++){
            out.println(new String(board[i]));
        }
//        out.println();
    }
}