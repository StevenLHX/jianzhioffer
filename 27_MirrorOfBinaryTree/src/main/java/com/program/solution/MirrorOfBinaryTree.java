package com.program.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class MirrorOfBinaryTree {
    //递归实现
    public static void mirrorTree(BinaryTreeNode root){
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            return;
        }
        BinaryTreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;
        if (root.left!=null){
            mirrorTree(root.left);
        }
        if (root.right!=null){
            mirrorTree(root.right);
        }
    }

    //循环实现
    public static BinaryTreeNode mirrorTree2(BinaryTreeNode root){
        if (root==null){
            return null;
        }
        //使用队列来实现
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode tempNode=queue.poll();
            if (tempNode.left!=null||tempNode.right!=null){
                //交换位置
                BinaryTreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;

                if (tempNode.left!=null){
                    queue.add(tempNode.left);
                }
                if (tempNode.right!=null){
                    queue.add(tempNode.right);
                }
            }
        }
        return root;
    }
}

//定义一个二叉树
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val=val;
    }

}