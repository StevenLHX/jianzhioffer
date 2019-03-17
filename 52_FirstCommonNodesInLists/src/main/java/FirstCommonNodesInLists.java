import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodesInLists {
    /**
     * 方法一
     * 借助于栈的先进后出，由于找到两个链表的第一个公共结点，故这个链表在公共结点以后是一个Y字型，
     * 故我们将两个链表放入栈中，来找到栈中最后一个相同的结点，即为链表的第一个公共结点。
     * （利用空间来换取时间）
     */
    public static ListNode findFirst(ListNode root1,ListNode root2){
        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();
        if (root1==null||root2==null){
            return null;
        }
        while (root1!=null){
            s1.push(root1);
            root1=root1.next;
        }
        while (root2!=null){
            s2.push(root2);
            root2=root2.next;
        }
        ListNode result=null;
        while (!s1.isEmpty()){
            ListNode l1=s1.peek();
            ListNode l2=s2.peek();
            if (l1.val==l2.val){
                result=s1.pop();
                s2.pop();
                continue;
            }
            return result;
        }
        return null;
    }

    /**
     * 方法二，高效的解法
     * 首先遍历两个链表得出两个链表的长度，得出长的链表比短的链表多几个元素，
     * 然后长的链表就先走几个元素，然后使其没有遍历的元素和短的链表的元素长度相等。
     * 然后再进行遍历，找到第一个公共结点。
     */
    public static ListNode findFirstCommonNode(ListNode root1,ListNode root2){
        if (root1==null||root2==null){
            return null;
        }
        int length1=getLength(root1);
        int length2=getLength(root2);
        ListNode pointLongListNode=null;
        ListNode pointShortListNode=null;
        int dif=0;
        if (length1>length2){
            pointLongListNode=root1;
            pointShortListNode=root2;
            dif=length1-length2;
        }else {
            pointLongListNode=root2;
            pointShortListNode=root1;
            dif=length2-length1;
        }
        for (int i=0;i<dif;i++){
            pointLongListNode=pointLongListNode.next;
        }
        while (pointLongListNode!=null&&pointShortListNode!=null
                &&pointLongListNode.val!=pointShortListNode.val){

            pointShortListNode=pointShortListNode.next;
            pointLongListNode=pointLongListNode.next;

        }
        return pointLongListNode;
    }
    //获取链表的长度
    private static int getLength(ListNode root){
        int length=0;
        ListNode point=root;
        while (point!=null){
            ++length;
            point=point.next;
        }
        return length;
    }

    //测试
    public static void main(String[] args) {
        ListNode root1=new ListNode(1);
        ListNode node11=new ListNode(2);
        ListNode node12=new ListNode(3);
        ListNode node13=new ListNode(6);
        ListNode node14=new ListNode(7);
        root1.next=node11;
        node11.next=node12;
        node12.next=node13;
        node13.next=node14;
        node14.next=null;
        ListNode root2=new ListNode(4);
        ListNode node21=new ListNode(5);
        ListNode node22=new ListNode(6);
        ListNode node23=new ListNode(7);
        root2.next=node21;
        node21.next=node22;
        node22.next=node23;
        node23.next=null;
        ListNode resultNode = findFirstCommonNode(root1, root2);
        ListNode test2node = findFirst(root1, root2);
        System.out.println(resultNode.val);
        System.out.println(test2node.val);
    }
}
//定义链表
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}