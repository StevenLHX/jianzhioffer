package com.program.solution;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是返回true，否则返回false。假设输入的数组的任意两个数字互不相同。
 */
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int[] arrs,int start,int end){
        if (start>=end){
            return true;
        }
        int root=arrs[end];//根节点
        int i=start;
        while (arrs[i]<root){
            i++;
        }
        int j=i;
        while (j<end){
            if (arrs[j]<root){
                return false;
            }
            j++;
        }
        //判断左右子树是否是二差搜索树
        boolean left = verifySquenceOfBST(arrs, start, i - 1);
        boolean right=verifySquenceOfBST(arrs,i,end-1);

        return left&&right;
    }

    public static void main(String[] args) {
        int[] arrs={5,7,6,9,11,10,8};
        boolean result = verifySquenceOfBST(arrs, 0, args.length - 1);
        System.out.println(result);
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