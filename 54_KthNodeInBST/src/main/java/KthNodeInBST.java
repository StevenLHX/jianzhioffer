/**
 * 二叉搜索树的第K大节点
 *
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNodeInBST {
    static int count;//遍历计数
    public static BinaryTreeNode getKthNodeInBST(BinaryTreeNode root,int k){
        if (root==null||k<=0){
            return null;
        }
        BinaryTreeNode target;
        if (root!=null){
            target=getKthNodeInBST(root.left,k);
            if (target!=null){
                return target;
            }
            count++;
            if (count==k){
                return root;
            }
            target=getKthNodeInBST(root.right,k);
            if (target!=null){
                return target;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(5);
        BinaryTreeNode node1=new BinaryTreeNode(3);
        BinaryTreeNode node2=new BinaryTreeNode(7);
        BinaryTreeNode node3=new BinaryTreeNode(2);
        BinaryTreeNode node4=new BinaryTreeNode(4);
        BinaryTreeNode node5=new BinaryTreeNode(6);
        BinaryTreeNode node6=new BinaryTreeNode(8);
        root.left=node1;
        root.right=node2;
        root.left.left=node3;
        root.left.right=node4;
        root.right.left=node5;
        root.right.right=node6;

        System.out.println(getKthNodeInBST(root,3).val);
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