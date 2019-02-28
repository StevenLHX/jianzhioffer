package com.program.solution;

import java.util.List;

/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1，2，3，4，5，6。这个链表的倒数第3个结点是值为4的结点。
 */
public class ReciprocalNumberKOfLink {
    public static ListNode findKthToTail(ListNode listHead,int k){
        if (listHead==null||k<=0){
            return null;
        }
        //前面的指向
        ListNode ahead=listHead;
        //先让ahead向前走k-1步
        for (int i=1;i<=k-1;i++){
            if (ahead.next!=null){
                ahead=ahead.next;
            }else {//当链表长度小于k时，返回null
                return null;
            }
        }
        //后来的指向
        ListNode behind=listHead;
        while (ahead.next!=null){
            ahead=ahead.next;
            behind=behind.next;
        }

        return behind;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode temp1=new ListNode();
        ListNode temp2=new ListNode();
        ListNode temp3=new ListNode();
        ListNode temp4=new ListNode();
        ListNode temp5=new ListNode();
        ListNode temp6=new ListNode();

        head.value=1;
        temp1.value=2;
        temp2.value=3;
        temp3.value=4;
        temp4.value=5;
        temp5.value=6;
        temp6.value=7;

        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        temp6.next=null;

        ListNode resultNode = findKthToTail(head, 2);
        if (resultNode!=null){
            System.out.println(resultNode.value);
        }else {
            System.out.println("您输入的参数有误！");
        }
    }

}

class ListNode{
    int value;
    ListNode next;
}
