package ByteDance.BigData2018_3;

/**
 * 将原始输入整理成魔方的形式，2*2魔方的转法有3*2=6种
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    static class Cube{
        int[] left=new int[4];
        int[] right=new int[4];
        int[] top=new int[4];
        int[] bottom=new int[4];
        int[] front=new int[4];
        int[] back=new int[4];
        Cube(int[] nums){
            top[0]=nums[0];
            top[1]=nums[1];
            top[2]=nums[2];
            top[3]=nums[3];

            bottom[0]=nums[19];
            bottom[1]=nums[18];
            bottom[2]=nums[17];
            bottom[3]=nums[16];

            front[0]=nums[6];
            front[1]=nums[7];
            front[2]=nums[12];
            front[3]=nums[13];

            back[0]=nums[23];
            back[1]=nums[22];
            back[2]=nums[21];
            back[3]=nums[20];

            left[0]=nums[4];
            left[1]=nums[5];
            left[2]=nums[10];
            left[3]=nums[11];

            right[0]=nums[8];
            right[1]=nums[9];
            right[2]=nums[14];
            right[3]=nums[15];
        }
    }
    public static int cal_side(int[] side){
        int sum=1;
        for(int i=0;i<4;i++)
            sum*=side[i];
        return sum;
    }
    public static int elegant(Cube cube){
        return cal_side(cube.left)+cal_side(cube.right)+cal_side(cube.top)+cal_side(cube.bottom)+cal_side(cube.front)
                +cal_side(cube.back);
    }
    public static void turn(int[] side ,int direct){
        if(direct==-1){
            int tmp=side[0];
            side[0]=side[2];
            side[2]=side[3];
            side[3]=side[1];
            side[1]=tmp;
        }
        else{
            int tmp=side[0];
            side[0]=side[1];
            side[1]=side[3];
            side[3]=side[2];
            side[2]=tmp;
        }
    }
    public static void turn(Cube cube,int type){
        switch(type){
            case 0:{
                turn(cube.top,-1);
                int[] tmp={cube.front[0],cube.front[1]};
                System.arraycopy(cube.right,0,cube.front,0,2);
                System.arraycopy(cube.back,0,cube.right,0,2);
                System.arraycopy(cube.left,0,cube.back,0,2);
                System.arraycopy(tmp,0,cube.left,0,2);
                break;
            }
            case 1:{
                turn(cube.top,1);
                int[] tmp={cube.front[0],cube.front[1]};
                System.arraycopy(cube.left,0,cube.front,0,2);
                System.arraycopy(cube.back,0,cube.left,0,2);
                System.arraycopy(cube.right,0,cube.back,0,2);
                System.arraycopy(tmp,0,cube.right,0,2);
                break;
            }
            case 2:{
                turn(cube.left,-1);
                int[] tmp={cube.front[0],cube.front[2]};
                cube.front[0]=cube.top[0];cube.front[2]=cube.top[2];
                cube.top[0]=cube.back[3];cube.top[2]=cube.back[1];
                cube.back[3]=cube.bottom[3];cube.back[1]=cube.bottom[1];
                cube.bottom[3]=tmp[0];cube.bottom[1]=tmp[1];
                break;
            }
            case 3:{
                turn(cube.left,1);
                int[] tmp={cube.front[0],cube.front[2]};
                cube.front[0]=cube.bottom[3];cube.front[2]=cube.bottom[1];
                cube.bottom[3]=cube.back[3];cube.bottom[1]=cube.back[1];
                cube.back[3]=cube.top[0];cube.back[1]=cube.top[2];
                cube.top[0]=tmp[0];cube.top[2]=tmp[1];
                break;
            }
            case 4:{
                turn(cube.front,-1);
                int[] tmp={cube.right[0],cube.right[2]};
                cube.right[0]=cube.top[2];cube.right[2]=cube.top[3];
                cube.top[2]=cube.left[3];cube.top[3]=cube.left[1];
                cube.left[3]=cube.bottom[2];cube.left[1]=cube.bottom[3];
                cube.bottom[2]=tmp[0];cube.bottom[3]=tmp[1];
                break;
            }
            case 5:{
                turn(cube.front,1);
                int[] tmp={cube.right[0],cube.right[2]};
                cube.right[0]=cube.bottom[2];cube.right[2]=cube.bottom[3];
                cube.bottom[2]=cube.left[3];cube.bottom[3]=cube.left[1];
                cube.left[3]=cube.top[2];cube.left[1]=cube.top[3];
                cube.top[2]=tmp[0];cube.top[3]=tmp[1];
                break;
            }
        }
    }
    public static int recur(Cube cube,int time){
        int result=elegant(cube);
        if(time>5) return result;
        time++;
        for(int i=0;i<6;i++){
            turn(cube,i);
            int tmp=elegant(cube);
            if(tmp>result) result=tmp;

            tmp=recur(cube,time);

            if(tmp>result) result=tmp;
            turn(cube,i%2==0?i+1:i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums=new int[24];
        for(int i=0;i<24;i++)
            nums[i]=scan.nextInt();
        Cube cube=new Cube(nums);

        int max=recur(cube,1);
        out.println(max);
    }
}
