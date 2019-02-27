package com.program.solution;

/**
 * 给定单链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */
public class DeleteNodeOfO1 {
    /**
     * @param head 链表的头结点
     * @param toBeDeleted 待删除的节点
     */
    public void deleteNode(ListNode head,ListNode toBeDeleted){
        //参数校验
        if (head==null||toBeDeleted==null){
            return;
        }
        //链表中只有一个节点，那么待删除的节点既是头结点，又是尾节点
        if (head==toBeDeleted&&head.nextNode==null){
            head=null;
        }else { //待删除的节点是尾节点
            if (toBeDeleted.nextNode==null){
                ListNode temp=head;
                while (temp.nextNode!=toBeDeleted){
                    temp=temp.nextNode;
                }
                temp.nextNode=null;
            }else { //待删除的节点不是尾节点
                toBeDeleted.nodeValue=toBeDeleted.nextNode.nodeValue;
                toBeDeleted.nextNode=toBeDeleted.nextNode.nextNode;
            }
        }
    }
    /**
     * 打印链表
     * @param head 链表的头结点
     */
    public void printList(ListNode head){
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.nodeValue+" ");
            temp=temp.nextNode;
        }
    }

    public static void main(String[] args) {
        DeleteNodeOfO1 test = new DeleteNodeOfO1();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();

        head.nodeValue = 1;
        temp1.nodeValue = 2;
        temp2.nodeValue = 3;
        temp3.nodeValue = 4;
        head.nextNode = temp1;
        temp1.nextNode = temp2;
        temp2.nextNode = temp3;
        temp3.nextNode = null;

        System.out.println("删除前的链表：");
        test.printList(head);

        System.out.println("-----------------------");

        test.deleteNode(head, temp3);       //执行删除操作
        System.out.println("删除后的链表：");
        test.printList(head);
    }
}

class ListNode{
    int nodeValue;
    ListNode nextNode;
}