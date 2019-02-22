package com.program.solution;

public class ReconstructedBinaryTree2 {
    public static BinaryTreeNode reconstructe(int[] preOrder,int[] inOrder){
        if (preOrder==null||inOrder==null||preOrder.length==0||inOrder.length==0||
                preOrder.length!=inOrder.length){
            return null;
        }
        //二叉树根节点
        BinaryTreeNode root=new BinaryTreeNode(preOrder[0]);
        root.setLeft(null);
        root.setRight(null);
        //左子树个数
        int leftNum=0;
        for (int i=0;i<inOrder.length;i++){
            if (root.getValue()==inOrder[i]){
                break;
            }else {
                leftNum++;
            }
        }
        //右子树个数
        int rightNum=inOrder.length-1-leftNum;

        //重建左子树
        if (leftNum>0){
            //左子树的先序序列
            int[] leftPreOrder=new int[leftNum];
            //左子树的中序序列
            int[] leftInOrder=new int[leftNum];
            for (int i=0;i<leftNum;i++){
                leftPreOrder[i]=preOrder[i+1];
                leftInOrder[i]=inOrder[i];
            }
            BinaryTreeNode leftRoot=reconstructe(leftPreOrder,leftInOrder);//递归构建左子树
            root.setLeft(leftRoot);

        }

        //重建右子树
        if (rightNum>0){
            int[] rightPreOrder=new int[rightNum];
            int[] rightInOrder=new int[rightNum];
            for (int i=0;i<rightNum;i++){
                rightPreOrder[i]=preOrder[leftNum+1+i];
                rightInOrder[i]=inOrder[leftNum+1+i];
            }
            BinaryTreeNode rightRoot=reconstructe(rightPreOrder,rightInOrder);
            root.setRight(rightRoot);
        }
        return root;
    }

    /**
     * 后序遍历二叉树
     * @param root
     */
    public static void printPostOrder(BinaryTreeNode root){
        if (root!=null){
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.println(root.getValue());
        }
    }
    public static void main(String[] args) {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        BinaryTreeNode root=reconstructe(preOrder,inOrder);
        printPostOrder(root);
    }
}
