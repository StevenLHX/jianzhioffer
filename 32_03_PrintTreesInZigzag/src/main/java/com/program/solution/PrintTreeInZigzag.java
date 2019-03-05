package com.program.solution;

import java.util.Stack;

/**
 * 按之字形打印二叉树
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，即第一行按照从左到右的顺序打印，第二层按照从右到左顺序打印，
 * 第三行再按照从左到右的顺序打印，其他以此类推。例如，按之字型打印下图的二叉树结果为：
 * 1
 * 3 2
 * 4 5 6 7
 * 15 14 13 12 11 10 9 8
 */
public class PrintTreeInZigzag {
    public static void printTreeToZ(BinaryTreeNode root){
        if (root==null){
            return;
        }
        //子节点的加入为：左-->右
        Stack<BinaryTreeNode> stack1=new Stack<>();//存储奇数层节点
        //子节点的加入为：右-->左
        Stack<BinaryTreeNode> stack2=new Stack<>();//存储偶数层节点
        stack1.add(root);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            //如果两个栈都为空，则退出循环
            if (stack1.isEmpty()&&stack2.isEmpty()){
                break;
            }
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    BinaryTreeNode temp=stack1.pop();
                    System.out.print(temp.val+" ");
                    if (temp.left!=null){
                        stack2.add(temp.left);
                    }
                    if (temp.right!=null){
                        stack2.add(temp.right);
                    }
                }
            }else {
                while (!stack2.isEmpty()){
                    BinaryTreeNode temp=stack2.pop();
                    System.out.print(temp.val+" ");
                    if (temp.right!=null){
                        stack1.add(temp.right);
                    }
                    if (temp.left!=null){
                        stack1.add(temp.left);
                    }
                }
            }
            System.out.println();
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
        printTreeToZ(root);
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