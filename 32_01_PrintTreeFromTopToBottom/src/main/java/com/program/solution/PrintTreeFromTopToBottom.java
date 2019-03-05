package com.program.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *
 * 从上往下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如输入下图的二叉树，则一次打印出8，6，10，5，7，9，11。
 */
public class PrintTreeFromTopToBottom {
    public static void fun(BinaryTreeNode root){
        if (root==null){
            return;
        }
        //定义队列
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //取出队列头部
            BinaryTreeNode tempNode=queue.poll();
            System.out.print(tempNode.val+" ");
            if (tempNode.left!=null){
                queue.add(tempNode.left);
            }
            if (tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(5);
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        fun(root);
    }

}
//定义二叉树
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}