package com.program.solution;

/**
 * 复杂链表的复制
 *
 * 复制一个复杂链表，
 * 在复杂链表中，每个结点除了有一个next指针指向下一个结点外，
 * 还有一个sbiling指向链表中的任意结点或者null。
 */
public class CopyComplexList {
    //TODO 复杂链表的复制
    public static ComplexListNode clone(ComplexListNode head){
        if (head==null){
            return null;
        }
        //创建复制后的链表
        cloneNodes(head);
        //连接复制节点的兄弟节点
        connectSibling(head);
        //将原始节点和复制节点分开
        return reconnectNodes(head);
    }

    //复制节点
    private static void cloneNodes(ComplexListNode head) {
        ComplexListNode nowNode=head;
        while (nowNode!=null){
            ComplexListNode cloneNode=new ComplexListNode(nowNode.val);
            cloneNode.next=nowNode.next;
            nowNode.next=cloneNode;
            nowNode=cloneNode.next;
        }
    }

    //连接复制节点的兄弟节点
    private static void connectSibling(ComplexListNode head) {
        ComplexListNode nowNode=head;
        while (nowNode!=null){
            ComplexListNode cloned=nowNode.next;
            if (nowNode.sibling!=null){
                cloned.sibling=nowNode.sibling.next;
            }
            nowNode=cloned.next;
        }
    }

    //将原始节点和复制节点分开
    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode clonedHead=head.next;
        ComplexListNode nowNode=head;
        while (nowNode!=null){
            ComplexListNode clonedNode=nowNode.next;
            nowNode.next=clonedNode.next;
            clonedNode.next=clonedNode.next==null?null:clonedNode.next.next;
            nowNode=nowNode.next;
        }
        return clonedHead;
    }

    public static void main(String[] args) {
        ComplexListNode head=new ComplexListNode(1);
        ComplexListNode node1=new ComplexListNode(2);
        ComplexListNode node2=new ComplexListNode(3);
        head.next=node1;
        node1.next=node2;
        head.sibling=node2;
        node1.sibling=node2;
        node2.sibling=head;

        ComplexListNode cloneHead = clone(head);
        while (cloneHead!=null){
            if (cloneHead.sibling!=null){
                System.out.println(cloneHead.sibling.val);
            }else {
                System.out.println("-");
            }
            cloneHead=cloneHead.next;
        }
    }
}
//定义复杂链表
class ComplexListNode{
    int val;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(int val) {
        this.val=val;
    }

}
