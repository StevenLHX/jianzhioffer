package com.program.solution;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class IsSubTree {

    //判断Tree1中是否含有Tree2
    public boolean hasSubtree(TreeNode root1,TreeNode root2){
        boolean result=false;
        if (root1!=null&&root2!=null){
            if (egual(root1.val,root2.val)){
                return DoesTreeHaveTree2(root1,root2);
            }
            if (result==false){
                result=hasSubtree(root1.left,root2);
            }
            if (result==false){
                result=hasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    //在两个二叉树根节点相等情况下，Tree1中是否含有Tree2
    private boolean DoesTreeHaveTree2(TreeNode root1, TreeNode root2) {
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if (!egual(root1.val,root2.val)){
            return false;
        }
        return DoesTreeHaveTree2(root1.left,root2.left)&&DoesTreeHaveTree2(root1.right,root2.right);
    }

    /**
     * 由于计算机表示小数（包括float和double型小数）都有误差，
     * 我们不能直接用等号（==）判断两个小数是否相等。
     * 如果两个小数的差的绝对值很小，如小于0.0000001，就可以认为它们相等。
     */
    boolean egual(double num1,double num2){
        if ((num1-num2>-0.0000001)&&(num1-num2<0.0000001)){
            return true;
        }else {
            return false;
        }
    }
}

//二叉树节点的定义
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;

    public TreeNode(int val){
        this.val=val;
    }
}