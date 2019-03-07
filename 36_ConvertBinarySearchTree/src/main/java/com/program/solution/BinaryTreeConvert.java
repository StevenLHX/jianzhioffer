package com.program.solution;

/**
 * 二叉搜索树与双向链表
 *
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建新的结点，只能调整树中结点指针的指向。
 */
public class BinaryTreeConvert {
    public static BinaryTreeNode convertNode(BinaryTreeNode root){
        //指向双向链表的尾节点
        BinaryTreeNode lastNodeList=null;
        convertNode(root,lastNodeList);
        //返回头结点
        BinaryTreeNode head=lastNodeList;
        while (head!=null&&head.left!=null){
            head=head.left;
        }
        return head;
    }

    //使用递归进行转换
    private static void convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeList) {
        if (node==null){
            return;
        }
        BinaryTreeNode currentNode=node;
        if (currentNode.left!=null){
            convertNode(currentNode.left,lastNodeList);
        }
        currentNode.left=lastNodeList;
        if (lastNodeList!=null){
            lastNodeList.right=currentNode;
        }
        lastNodeList=currentNode;
        if (currentNode.right!=null){
            convertNode(currentNode.right,lastNodeList);
        }
    }
}
//定义二叉树
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
}