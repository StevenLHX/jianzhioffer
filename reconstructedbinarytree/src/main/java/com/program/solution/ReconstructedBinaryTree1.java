package com.program.solution;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重新构造出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中不包含重复的数字。
 * 例如输入的前序遍历序列为｛1，2，4，7，3，5，6，8｝和中序遍历为{4,7,2,1,5,3,6,8},
 * 则重建出二叉树并输出它的头结点。
 */
public class ReconstructedBinaryTree1 {
    /**
     * 二叉树节点类
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }
    public TreeNode reconstructe(int[] preOrder, int[] inOrder){
        if (preOrder==null||inOrder==null||preOrder.length==0||inOrder.length==0||
                preOrder.length!=inOrder.length){
            return null;
        }
        return construct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    /**
     *
     * @param preOrder 前序遍历
     * @param ps 前序遍历开始位置
     * @param pe 前序遍历结束位置
     * @param inOrder 中序遍历
     * @param is 中序遍历开始位置
     * @param ie 中序遍历结束位置
     * @return  树的根节点
     */
    private TreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        if(ps>pe) return null;
        int value=preOrder[ps];//取前序遍历的第一个数字就是根节点
        //在中序遍历中寻找根节点
        int index=is;
        while (index<=ie&&value!=inOrder[index]){
            index++;
        }
        //如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的
        if(index>ie){
            throw new RuntimeException("Invalid Input");
        }
        //创建当前根节点，并为根节点赋值
        TreeNode node=new TreeNode(value);
        //递归调用构建当前节点左子树
        node.left=construct(preOrder,ps+1,ps+index-is,inOrder,is,index-1);
        //递归调用构建当前节点右子树
        node.right=construct(preOrder,ps+index-is+1,pe,inOrder,index+1,ie);
        return node;
    }

    private void printTree(TreeNode root){
        if (root!=null){
            printTree(root.left);
            System.out.println(root.val+" ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        ReconstructedBinaryTree1 tree=new ReconstructedBinaryTree1();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode node=tree.reconstructe(pre,in);
        tree.printTree(node);
    }

}
