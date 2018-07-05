package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 For example:
 Given binary tree{1,#,2,3},
 1
 \
 2
 /
 3

 return[3,2,1].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Postorder_Traversal {
    public void recur(TreeNode root,ArrayList<Integer> res){
        if(root.left!=null) recur(root.left,res);
        if(root.right!=null) recur(root.right,res);
        res.add(root.val);
        return;
    }
    public ArrayList<Integer> recur_way(TreeNode root){
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        recur(root,res);
        return res;
    }
    public ArrayList<Integer> iter_way(TreeNode root){
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        Stack stack=new Stack();
        stack.push(root);
        TreeNode lastNode=null;
        while(!stack.isEmpty()){
            TreeNode node=(TreeNode) stack.peek();
            if(lastNode==null){
                if(node.left!=null) stack.push(node.left);
                else if(node.right!=null) stack.push(node.right);
                else{
                    res.add(node.val);
                    lastNode=node;
                    stack.pop();
                }
            }
            else{
                if(lastNode==node.left){
                    if(node.right!=null){
                        stack.push(node.right);
                        lastNode=null;
                    }
                    else{
                        res.add(node.val);
                        lastNode=node;
                        stack.pop();
                    }
                }
                else{
                    res.add(node.val);
                    lastNode=node;
                    stack.pop();
                }
            }
        }
        return res;
    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        return recur_way(root);
//        return iter_way(root);
    }
}
