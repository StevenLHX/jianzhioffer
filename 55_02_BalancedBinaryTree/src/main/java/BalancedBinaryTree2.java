/**
 * 方法二
 * 后续遍历
 * 只遍历一遍
 */
public class BalancedBinaryTree2 {
    private boolean isBanlance=false;
    public boolean isBalance_Solution(BinaryTreeNode2 root){
        getDepth(root);
        return isBanlance;
    }
   public int getDepth(BinaryTreeNode2 root){
        if (root==null){
            isBanlance=true;
            return 0;
        }
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        int depth=left>right?left+1:right+1;
        if (Math.abs(left-right)<=1){
            isBanlance=true;
        }else {
            isBanlance=false;
        }
        return depth;//下层的深度，上层可以接着用免得再遍历
    }
}
//定义二叉树
class BinaryTreeNode2 {
    int val;
    BinaryTreeNode2 left;
    BinaryTreeNode2 right;
    BinaryTreeNode2(int val) {
        this.val = val;
    }
}