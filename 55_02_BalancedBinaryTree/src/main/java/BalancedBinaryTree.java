/**
 * 平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树就是左子树和右子树的高度差（深度差）不能超过1，且左右子树必须是平衡二叉树；
 */
public class BalancedBinaryTree {
    public static boolean isBalaceBinaryTree(BinaryTreeNode root){
        if (root==null){
            return true;
        }
        int left=getTreeDepth(root.left);
        int right=getTreeDepth(root.right);
        int diff=left-right;
        if (diff>1||diff<-1){
            return false;
        }
        return isBalaceBinaryTree(root.left)&&isBalaceBinaryTree(root.right);
    }
    public static int getTreeDepth(BinaryTreeNode root){
        if (root==null){
            return 0;
        }
        int left=getTreeDepth(root.left);
        int right=getTreeDepth(root.right);
        return left>right?left+1:right+1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(1);
        BinaryTreeNode node1=new BinaryTreeNode(2);
        BinaryTreeNode node2=new BinaryTreeNode(3);
        BinaryTreeNode node3=new BinaryTreeNode(4);
        BinaryTreeNode node4=new BinaryTreeNode(5);
        BinaryTreeNode node5=new BinaryTreeNode(6);
        BinaryTreeNode node6=new BinaryTreeNode(7);
        root.left=node1;
        root.right=node2;
        root.left.left=node3;
        root.left.right=node4;
        root.left.right.left=node6;
        root.right.right=node5;

        System.out.println(isBalaceBinaryTree(root));

    }
}
//定义二叉树
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int val){
        this.val=val;
    }
}