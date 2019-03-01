package com.program.solution;

import java.util.List;

/**
 * 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 例如输入图中的链表1和链表2，则合并之后的升序链表3所示。
 */
public class MergeList {
    public ListNode merge(ListNode head1,ListNode head2){
        if (head1==null&&head2==null){
            return null;
        }
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        ListNode mergeHead=null;
        if (head1.value<head2.value){
            mergeHead=head1;
            mergeHead.next=merge(head1.next,head2);
        }else {
            mergeHead=head2;
            mergeHead.next=merge(head1,head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        MergeList test=new MergeList();
        //链表1
        ListNode head1=new ListNode();
        ListNode node11=new ListNode();
        ListNode node12=new ListNode();
        ListNode node13=new ListNode();
        head1.value=1;
        node11.value=3;
        node12.value=5;
        node13.value=7;
        head1.next=node11;
        node11.next=node12;
        node12.next=node13;
        node13.next=null;

        //链表2
        ListNode head2=new ListNode();
        ListNode node21=new ListNode();
        ListNode node22=new ListNode();
        ListNode node23=new ListNode();
        head2.value=2;
        node21.value=4;
        node22.value=6;
        node23.value=8;
        head2.next=node21;
        node21.next=node22;
        node22.next=node23;
        node23.next=null;

        printList(head1);
        System.out.println();
        printList(head2);
        System.out.println();

        ListNode mergeList = test.merge(head1, head2);
        printList(mergeList);

    }

    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
    }

}

class ListNode{
    int value;
    ListNode next;
}