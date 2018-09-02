package ByteDance.BigData2018_2;

/**
 * Created by cycy on 2018/8/21.
 */
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static int t(ArrayList<Integer> list,int front,int limit,int num){
        if(list.size()-front<num) return -1;
        int sum=0;
        if(num%2==1){
            int mid=(front+num)/2;
            int mid_pos=list.get(mid);
            int left=mid_pos-1,right=mid_pos+1;
            int move=1;
            int step=(num+1)/2;
            while(move<step&&sum<=limit){
                sum+=left-list.get(mid-move)+list.get(mid+move)-right;
                move++;
                left--;
                right++;
            }
            if(move<step||sum>limit) return -1;
        }
        else{
            int left_end=(front+num)/2-1,right_end=left_end+1;
            int left=(list.get(left_end)+list.get(right_end))/2,right=left+1;
            int step=num/2;
            int move=0;
            while(move<step&&sum<=limit){
                sum+=left-list.get(left_end-move)+list.get(right_end+move)-right;
                move++;
                left--;
                right++;
            }
            if(move<step||sum>limit) return -1;
        }
        if(sum<=limit){
            return Math.max(t(list,front,limit,num+1),num);
        }
        else return -1;
    }
    public static int together(ArrayList<Integer> list,int leastnum,int limit){
        int max=leastnum;
        boolean find=false;
        for(int i=0;i<=list.size()-max;i++){
            int tmp=t(list,i,limit,max);
            if(tmp>=max) {
                max=tmp;
                find=true;
            }
        }
        if(find) {
//            out.println(list+" max: "+max);
            return max;
        }
        else return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s=scan.next();
        int m=scan.nextInt();
        ArrayList<Integer>[] pos=new ArrayList[26];
        for(int i=0;i<26;i++)
            pos[i]=new ArrayList<Integer>();
        for(int i=0;i<s.length();i++)
            pos[s.charAt(i)-'a'].add(i);
        int max=1;
        for(int i=0;i<26;i++){
            if(pos[i].size()<=max) continue;
            int tmp=together(pos[i],max+1,m);
            if(tmp>max) max=tmp;
        }
        out.println(max);
    }
}

/**
 *
ooxnwetkuvpqjuabmovhkpypxbgpxzemuupqvavonyfscmkrvsvixcejdrutwwfndzkdxbrwgptievanpqfzlprwyqupidspcgrw 200 8
lufhkcyqnnheshcogbovclcxrfneppkxdvolqtstdkmgsscvfvnnigltgyardkfvavrrwbblzcxzwmteonksiaswfvfsgpxwosev 200 8
 */

