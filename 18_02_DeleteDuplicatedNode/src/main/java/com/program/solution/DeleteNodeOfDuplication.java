package com.program.solution;

/**
 * 删除链表中的重复节点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如：
 * 输入链表：1->2->3->3->4->4->5
 * 处理结果：1->2->5
 */
public class DeleteNodeOfDuplication {
    public ListNode deleteDuplication(ListNode head){
        if (head==null){
            return null;
        }
        ListNode preNode=new ListNode();
        ListNode tmp=preNode;
        preNode.nextNode=head;
        ListNode nowNode=head;

        while (nowNode!=null){
            if (nowNode.nextNode!=null&&nowNode.nodeValue==nowNode.nextNode.nodeValue){
                while (nowNode.nextNode!=null&&nowNode.nodeValue==nowNode.nextNode.nodeValue){
                    nowNode=nowNode.nextNode;
                }
                preNode.nextNode=nowNode.nextNode;//删除相应的重复节点
            }else {
                preNode=nowNode;
            }
            nowNode=nowNode.nextNode;
        }
        return tmp.nextNode;
    }

    /**
     * 打印链表
     * @param head 链表的头结点
     */
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.nodeValue + "  ");
            temp = temp.nextNode;
        }
    }

    public static void main(String[] args) {
        DeleteNodeOfDuplication test = new DeleteNodeOfDuplication();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.nodeValue = 1;
        temp1.nodeValue = 3;
        temp2.nodeValue = 3;
        temp3.nodeValue = 3;
        temp4.nodeValue = 5;
        temp5.nodeValue = 5;
        temp6.nodeValue = 7;
        head.nextNode = temp1;
        temp1.nextNode = temp2;
        temp2.nextNode = temp3;
        temp3.nextNode = temp4;
        temp4.nextNode = temp5;
        temp5.nextNode = temp6;
        temp6.nextNode = null;

        System.out.println("删除前的链表：");
        test.printList(head);

        System.out.println();
        System.out.println("-----------------------");

        ListNode resultList = test.deleteDuplication(head); // 执行删除操作
        System.out.println("删除后的链表：");
        test.printList(resultList);
    }
}
class ListNode{
    int nodeValue;
    ListNode nextNode;
}