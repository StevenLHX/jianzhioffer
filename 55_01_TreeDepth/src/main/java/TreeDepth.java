/**
 * 二叉树的深度
 */
public class TreeDepth {
    public static int getTreeDepth(BinaryTreeNode root){
        if (root==null){
            return 0;
        }
        int left=getTreeDepth(root.left);
        int right=getTreeDepth(root.right);
        int result;
        if (left>right){
            result=left+1;
        }else {
            result=right+1;
        }
        return result;
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

        System.out.println(getTreeDepth(root));

    }
}
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int val){
        this.val=val;
    }
}