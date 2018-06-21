import java.util.Scanner;

/**
 * Created by cycy on 2018/4/2.
 */



public class Main_reConstructBinaryTree {
    public int findnode(int[] in,int target,int f,int b){
        for(int i=f;i<=b;i++){
            if(in[i]==target) return i;
        }
        return -1;
    }
    public int reConstructCore(int[] pre, int[] in, TreeNode root, int pre_root, int in_f, int in_b){
        int root_in_index=findnode(in,root.val,in_f,in_b);
        int pre_left_farthest=pre_root;
//        out.println(root.val+"\troot_in:"+root_in_index+"\tin_f:"+in_f+"\tin_b:"+in_b);
//        if(pre_root>=pre.length-1){//说明遍历完成
//            return pre_root;
//        }
        if(root_in_index==in_f){//说明没有左子树
            root.left=null;
        }
        else{//有左子树，则pre的下一个就是左子树的根
            TreeNode left=new TreeNode(pre[pre_root+1]);
            root.left=left;
            pre_left_farthest=reConstructCore(pre,in,left,pre_root+1,in_f,root_in_index-1);
        }
//        if(pre_left_farthest>=pre.length-1){
//            root.right=null;
//            return pre_root;
//        }
        if(root_in_index==in_b){//说明没有右子树
            root.right=null;
            return pre_left_farthest;//
        }
        else{//有右子树，则最左子树在pre的下一下就是右子树的根
            TreeNode right=new TreeNode(pre[pre_left_farthest+1]);
            root.right=right;
            return reConstructCore(pre,in,right,pre_left_farthest+1,root_in_index+1,in_b);
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length<=0||in.length<=0) return null;
        TreeNode root=new TreeNode(pre[0]);
        reConstructCore(pre,in,root,0,0,in.length-1);
        return root;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
//        int k=scan.nextInt();
//        int[] pre=new int[k];
//        int[] in=new int[k];
//        for(int i=0;i<k;i++) pre[i]=scan.nextInt();
//        for(int i=0;i<k;i++) in[i]=scan.nextInt();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        Main_reConstructBinaryTree tmp=new Main_reConstructBinaryTree();
        tmp.reConstructBinaryTree(pre,in);
    }

}
