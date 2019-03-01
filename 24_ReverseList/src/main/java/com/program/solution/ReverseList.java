package com.program.solution;

/**
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表的头结点。链表结点如下：
 */
public class ReverseList {
    //遍历，将当前节点的下一个节点缓存后更改当前节点指针
    public ListNode reverse(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }

        ListNode pre=head;//上一节点
        ListNode cur=head.getNext();//当前节点
        ListNode temp;//临时节点，用于保存当前节点的指针域（即下一节点）

        while (cur!=null){//如果为null，则是尾节点
            temp=cur.getNext();//下一节点
            cur.setNext(pre);//将指针域指向上一节点
            //节点向下移动
            pre=cur;
            cur=temp;
        }
        head.setNext(null);//最后将原链表的头结点指针域设置为null，此时原链表的头结点为新链表的尾节点
        //此时pre已经移动到原链表的尾节点，也是新链表的头结点
        return pre;

    }

    public static void main(String[] args) {
        ReverseList test = new ReverseList();

        ListNode head = new ListNode(0);
        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        ListNode temp3 = new ListNode(3);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);

        head.setNext(temp1);
        temp1.setNext(temp2);
        temp2.setNext(temp3);
        temp3.setNext(temp4);
        temp4.setNext(temp5);
        temp5.setNext(null);

        System.out.println("反转前：");
        printList(head);
        System.out.println();
        //执行反转操作
        ListNode reverseHead = test.reverse(head);
        test.printList(reverseHead);

    }

    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.getValue()+" ");
            head=head.getNext();
        }
    }
}
class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}