package com.program.solution;

/**
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树和它的镜像是一样的，那么它是对称的。
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root,root);
    }
    public boolean isSymmetrical(BinaryTreeNode root1,BinaryTreeNode root2){
        if (root1==null&&root2==null){
            return true;
        }
        if (root1==null||root2==null){
            return false;
        }
        if (root1.val!=root1.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
    }
}
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val=val;
    }
}