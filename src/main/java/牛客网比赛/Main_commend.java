package 牛客网比赛;

import java.util.*;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/3/25.
 */
class c{
    String name;
    c par;
    List<c> direct_child;
    Set<String> sub_child;
    c(String p,c parent){
        par=parent;
        name=p;
        direct_child=new ArrayList<c>();
        sub_child=new HashSet<String>();
    }
    void addChild(String str){
        if(!str.equals("*")) {
            direct_child.add(new c(str, this));
            sub_child.add(str);
        }
        if(!name.equals("A")){
            par.add_subChild(str);
        }
    }
    void add_subChild(String child){
        if(!child.equals("*")) sub_child.add(child);
    }
}

public class Main_commend{
    public static void form_tree(String[][] list,c curnode){
        int index=0;
        while(index<list.length&&!list[index][0].equals(curnode.name)) index++;
        if(index<list.length) {
            curnode.addChild(list[index][1]);
            curnode.addChild(list[index][2]);
            form_tree(list,curnode.direct_child.get(0));
            if(curnode.direct_child.size()==2) form_tree(list,curnode.direct_child.get(1));
        }
        return;
    }
    public static boolean printnode(c curnode,int n){
        boolean find=false;
//        out.println("\""+curnode.name+"\"");
        if(curnode.sub_child.size()>=n){
            if(!curnode.name.equals("A")) out.print(" "+curnode.name);
            else out.print(curnode.name);
            find=true;
        }
        for(c ch:curnode.direct_child) {
            find=printnode(ch,n) || find;
        }
        return find;
    }
    public static void print_all(c curnode){
        out.print(curnode.name+" -> ");
        for(c ch:curnode.direct_child){
            out.print(ch.name+" ");
        }
        out.print("||");
        for(String str:curnode.sub_child)
            out.print(str+" ");
        out.println();
        for(c ch:curnode.direct_child) print_all(ch);
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int m=scan.nextInt();
        int n=scan.nextInt();
        scan.nextLine();
        if(m==0) {
            out.println("None");
            return;
        }
        String[][] list=new String[m][3];
        for(int i=0;i<m;i++){
            String str=scan.nextLine();
//            out.println(str);
            list[i]=str.split(" ");
        }
        c root=new c("A",null);
        form_tree(list,root);
//        print_all(root);
        if(!printnode(root,n)){
            out.println("None");
        }
    }
}