package com.program.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 序列化和反序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 前提：
 * 节点都是0-9之间的数字，且不重复
 */
public class SerializeBinaryTrees {

    //序列化
    public static String serialize(BinaryTreeNode root){
        StringBuffer sb=new StringBuffer();
        if (root==null){
            sb.append("$,");
        }else {
            sb.append(root.val+",");
            sb.append(serialize(root.left)+",");
            sb.append(serialize(root.right)+",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring;
    }

    //反序列化
    public static BinaryTreeNode deSerialize(String str){
        String[] s=str.split(",");
        Queue<String> queue=new LinkedList<>();
        for (int i=0;i<s.length;i++){
            queue.add(s[i]);
        }
        return preOrder(queue);
    }
    private static BinaryTreeNode preOrder(Queue<String> queue) {
        String val=queue.poll();
        if (val.equals("$")){
            return null;
        }
        BinaryTreeNode node=new BinaryTreeNode(Integer.valueOf(val));
        node.left=preOrder(queue);
        node.right=preOrder(queue);
        return node;
    }

    //按前序遍历打印二叉树
    public static void pringTree(BinaryTreeNode root){
        if (root==null){
            return;
        }
        Stack<BinaryTreeNode> stack=new Stack<>();
        BinaryTreeNode node=root;
        while (node!=null||stack.size()>0){
            if (node!=null){
                System.out.print(node.val);
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                node=node.right;
            }
        }
    }

    //测试
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.right.left=new BinaryTreeNode(5);
        root.right.right=new BinaryTreeNode(6);

        String serializeResult = serialize(root);
        System.out.println(serializeResult);
        BinaryTreeNode treeNode = deSerialize(serializeResult);
        pringTree(treeNode);
    }

}

//定义二叉树
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val=val;
    }
}