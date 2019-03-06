package com.program.solution;

import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 路径定义为从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class FindPathInBinaryTree {
    public static void findPathInTree(BinaryTreeNode root,int sum){
        if (root==null){
            return;
        }
        //使用栈来保存路径上的节点
        Stack<Integer> stack=new Stack<>();
        int currentSum=0;

        findPath(root,sum,stack,currentSum);
    }

    private static void findPath(BinaryTreeNode root, int sum, Stack<Integer> stack, int currentSum) {
        stack.push(root.val);
        currentSum+=root.val;
        boolean isLeaf=(root.left==null&&root.right==null);//是否为叶子节点
        //如果该节点为叶子节点，并且路径和等于sum
        if (isLeaf&&currentSum==sum){
            //打印路径
            printStack(stack);
        }
        //如果不是叶子节点，则遍历它的子节点
        if (root.left!=null){
            findPath(root.left,sum,stack,currentSum);
        }
        if (root.right!=null){
            findPath(root.right,sum,stack,currentSum);
        }
        //在返回父节点之前，在路径上删除当前节点
        stack.pop();
        //当前值减去被删节点的值
        currentSum-=root.val;
    }

    //打印栈（从栈底到栈顶打印）
    private static void printStack(Stack<Integer> stack) {
        Stack<Integer> tempStack=new Stack<>();
        while (!stack.isEmpty()){
            tempStack.add(stack.pop());
        }
        while (!tempStack.isEmpty()){
            int num=tempStack.pop();
            System.out.print(num+" ");
            stack.add(num);
        }
        System.out.println();
    }

    //测试
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(10);
        root.left=new BinaryTreeNode(5);
        root.right=new BinaryTreeNode(12);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(7);
        findPathInTree(root,22);
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