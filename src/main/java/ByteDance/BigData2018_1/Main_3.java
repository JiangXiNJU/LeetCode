package ByteDance.BigData2018_1;

/**
 * 时间限制：1秒
 空间限制：81920K
 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。
 对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，
 如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 求每个idea实现的时间。
 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。
 随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。输出P行，分别表示每个idea实现的时间点。

 输入描述:
 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。
 随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。全部数据范围 [1, 3000]。


 输出描述:
 输出P行，分别表示每个idea实现的时间点。

 输入例子1:
 2 2 5
 1 1 1 2
 1 2 1 1
 1 3 2 2
 2 1 1 2
 2 3 5 5

 输出例子1:
 3
 4
 5
 3
 9
 */
import java.util.*;

import static java.lang.System.out;

public class Main_3 {
    static class PM{
        Queue<idea> Ideas_already=new PriorityQueue<idea>(16,new Comparator<idea>() {
            public int compare(idea o1, idea o2) {
                if(o1.priority>o2.priority) return -1;
                else if(o1.priority<o2.priority) return 1;
                else{
                    if(o1.lasttime<o2.lasttime) return -1;
                    else if(o1.lasttime>o2.lasttime) return 1;
                    else{
                        if(o1.submit<o2.submit) return -1;
                        else return 1;
                    }
                }
            }
        });
        Queue<idea> Ideas_thinking=new PriorityQueue<idea>(16, new Comparator<idea>() {
            public int compare(idea o1, idea o2) {
                if(o1.submit<o2.submit) return -1;
                else return 1;
            }
        });
        void move_ideas(int submit){
            while(!Ideas_thinking.isEmpty()&&Ideas_thinking.peek().submit<=submit){
                Ideas_already.offer(Ideas_thinking.poll());
            }
        }
    }
    static class idea{
        int index,submit,priority,lasttime,finish;
        idea(int _s,int _p,int _l,int _i){
            priority=_p;
            lasttime=_l;
            submit=_s;
            index=_i;
        }
    }
    public static void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public static void adjustMin_Heap(int[] coder,int target){
        int m=coder.length;
        int last_parent=m/2-1;
        if(target>last_parent) return;
        while(target<=last_parent){
            int left=target*2+1,right=target*2+2;
            if(right<m){
                if(coder[target]<=coder[left]&&coder[target]<=coder[right]) return;
                int next_index=coder[left]<coder[right]?left:right;
                swap(coder,target,next_index);
                target=next_index;
            }
            else{
                if(coder[target]<=coder[left]) return;
                swap(coder,target,left);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),m=scan.nextInt(),p=scan.nextInt();
        PM[] pms=new PM[n];
        for(int i=0;i<n;i++)
            pms[i]=new PM();
        idea[] Idea=new idea[p];
        int[] coder=new int[m];
        for(int i=0;i<p;i++){
            int pm=scan.nextInt();
            Idea[i]=new idea(scan.nextInt(),scan.nextInt(),scan.nextInt(),i);
            pms[pm-1].Ideas_thinking.offer(Idea[i]);
        }

        int remain=p;
        while(remain>0){
            remain--;
            int target_idea=-1,target_pm=-1,target_time=Integer.MAX_VALUE;
            int now=coder[0]-1;
            boolean find=false;
            while(!find){
                now++;
                for(int i=0;i<n;i++){
                    pms[i].move_ideas(now);
                    if(!pms[i].Ideas_already.isEmpty()) {
                        find=true;
                        idea tmp = pms[i].Ideas_already.peek();
                        if (tmp.lasttime < target_time) {
                            target_idea = tmp.index;
                            target_pm = i;
                            target_time = tmp.lasttime;
                        }
                    }
                }
            }
            coder[0]=now;
            for(int i=1;i<m;i++)
                coder[i]=Math.max(coder[i],now);
            out.println("目标idea: "+target_idea);
            coder[0]+=Idea[target_idea].lasttime;
            Idea[target_idea].finish=coder[0];
            adjustMin_Heap(coder,0);
            pms[target_pm].Ideas_already.poll();
        }

        for(int i=0;i<p;i++)
            out.println(Idea[i].finish);
    }
}
