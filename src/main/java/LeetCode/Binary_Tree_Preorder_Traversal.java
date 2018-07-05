package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 For example:
 Given binary tree{1,#,2,3},
 1
 \
 2
 /
 3

 return[1,2,3].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Preorder_Traversal {
    public void recur(TreeNode root,ArrayList<Integer> res){
        res.add(root.val);
        if(root.left!=null) recur(root.left,res);
        if(root.right!=null) recur(root.right,res);
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

        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        res.add(root.val);
        TreeNode lastNode=null;
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(lastNode==null){
                if(node.left!=null){
                    stack.push(node.left);
                    res.add(node.left.val);
                }
                else if(node.right!=null){
                    stack.push(node.right);
                    res.add(node.right.val);
                }
                else{
                    lastNode=stack.pop();
                }
            }
            else if(lastNode==node.left){
                if(node.right!=null){
                    stack.push(node.right);
                    res.add(node.right.val);
                    lastNode=null;
                }
                else{
                    lastNode=stack.pop();
                }
            }
            else lastNode=stack.pop();
        }
        return res;
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        return recur_way(root);
//        return iter_way(root);
    }
}
