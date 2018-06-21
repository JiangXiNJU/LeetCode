import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/12.
 */

public class Solution_BinarySearchTree2LinkedList {
    public TreeNode most_right(TreeNode t,TreeNode root){
        if(t==null) return t;
        if(t.right==null) {
            t.right=root;
            return t;
        }
        return most_right(t.right,root);
    }
    public TreeNode most_left(TreeNode t,TreeNode root){
        if(t==null) return t;
        if(t.left==null) {
            t.left=root;
            return t;
        }
        return most_left(t.left,root);
    }
    public void updateNonLeaf(TreeNode t){
        if(t==null) return;
        out.println(t.val);
        if(t.left!=null&&t!=t.left.right){
            TreeNode l=t.left;
            t.left=most_right(l,t);
            out.println(t.left.val);
            updateNonLeaf(l);
        }
        if(t.right!=null&&t!=t.right.left){
            TreeNode r=t.right;
            t.right=most_left(r,t);
            out.println(t.right.val);
            updateNonLeaf(r);
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode mostleft=null;
        if(pRootOfTree==null) return null;
        mostleft=pRootOfTree;
        while(mostleft.left!=null){
            mostleft=mostleft.left;
        }
        updateNonLeaf(pRootOfTree);
        return mostleft;
    }
    public TreeNode buildBinarySearchTree(int[] array){
        Queue<TreeNode> tree=new LinkedList<TreeNode>();
        TreeNode root=new TreeNode(array[0]);
        int index=1;
        tree.offer(root);
        while(index<array.length){
            TreeNode t=tree.poll();
            if(array[index]==-1){
                t.left=null;
            }
            else {
                t.left=new TreeNode(array[index]);
                tree.offer(t.left);
            }
            index++;
            if(array[index]==-1){
                t.right=null;
            }
            else {
                t.right=new TreeNode(array[index]);
                tree.offer(t.right);
            }
            index++;
        }
        return root;
    }
    public void printTree(TreeNode root){
        Queue<TreeNode> tree=new LinkedList<TreeNode>();
        tree.offer(root);
        int layer=root.val;
        while(tree.isEmpty()==false){
            TreeNode tmp=tree.poll();
            out.print(tmp.val+" ");
            if(tmp.left!=null) tree.offer(tmp.left);
            if(tmp.right!=null) tree.offer(tmp.right);
        }

    }
    public static void main(String[] args){
        int[] array={10,6,14,4,8,12,16};
        Solution_BinarySearchTree2LinkedList s=new Solution_BinarySearchTree2LinkedList();
        TreeNode root=s.buildBinarySearchTree(array);
        s.printTree(root);
        Scanner scan=new Scanner(System.in);
        scan.next();
        TreeNode left=s.Convert(root);
        while(left.right!=null) {
            out.print(left.val+" ");
            left=left.right;
        }
        String str="";
        char[] chars=str.toCharArray();
        String str0=new String(chars);
    }
}