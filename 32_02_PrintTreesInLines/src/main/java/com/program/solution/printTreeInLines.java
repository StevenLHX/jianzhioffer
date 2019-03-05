package com.program.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印 ，每一层打印一行。
 */
public class printTreeInLines {
    BinaryTreeNode flagNode=new BinaryTreeNode(-1);
    public static void printTreeLine(BinaryTreeNode root){
        if (root==null){
            return;
        }
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        //两者都是往队列尾部插入元素，不同的是，
        //当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false。
        queue.offer(root);
        BinaryTreeNode temp;
        while (!queue.isEmpty()){
            for (int i=queue.size();i>0;i--){
                temp=queue.poll();
                System.out.print(temp.val);
                System.out.print("\t");
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(5);
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        printTreeLine(root);
    }

}

//定义二叉树
class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}