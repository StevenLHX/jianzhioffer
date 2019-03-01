package com.program.solution;

/**
 * 递归实现
 */
public class ReverseList2 {
    //递归，在反转当前节点之前先反转后续节点
    public static ListNode2 reverse2(ListNode2 head){
        //head看作是前一节点，head.getNexxt()是当前结点，
        if (head==null||head.getNext()==null){
            return null;
        }

        //TODO 有问题
        //先反转后续节点
        ListNode2 reHead = reverse2(head.getNext());
        head.getNext().setNext(head); //将当前节点的指针域指向上一节点
        head.setNext(null); //前一节点的指针域改为null
        return reHead;  //返回反转后的新链表的节点

    }

    public static void main(String[] args) {
        ReverseList2 test = new ReverseList2();

        ListNode2 head = new ListNode2(0);
        ListNode2 temp1 = new ListNode2(1);
        ListNode2 temp2 = new ListNode2(2);
        ListNode2 temp3 = new ListNode2(3);
        ListNode2 temp4 = new ListNode2(4);
        ListNode2 temp5 = new ListNode2(5);

        head.setNext(temp1);
        temp1.setNext(temp2);
        temp2.setNext(temp3);
        temp3.setNext(temp4);
        temp4.setNext(temp5);
        //temp5.setNext(null);

        System.out.println("反转前：");
        printList(head);
        System.out.println();
        //执行反转操作
        ListNode2 reverseHead = test.reverse2(head);
        test.printList(reverseHead);

    }


    public static void printList(ListNode2 head){
        while (head!=null){
            System.out.print(head.getValue()+" ");
            head=head.getNext();
        }
    }
}
class ListNode2{
    int value;
    ListNode2 next;

    public ListNode2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode2 getNext() {
        return next;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }
}