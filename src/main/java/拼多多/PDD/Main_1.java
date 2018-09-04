package 拼多多.PDD;

import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long hp=scan.nextInt();
        long na=scan.nextInt();
        long ba=scan.nextInt();
        long step=0;
        if(ba<=na*2){
            step=hp%na==0?hp/na:hp/na+1;
        }
        else{
            step+=hp/ba*2;
            if(hp%ba>0){
                hp%=ba;
                if(hp/na>=2) step+=2;
                else step+=hp%na==0?hp/na:hp/na+1;
            }

        }
        out.println(step);
    }
}