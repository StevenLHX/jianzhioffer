package com.program.solution;

import java.util.Stack;

/**
 * 重尾到头打印链表
 *
 * 输入一个链表，从尾到头打印链表每个节点的值。返回新链表。
 * 分析：
 * 可以借助栈也可以使用递归
 *
 */
public class PrintListReverse {
    //用栈的思想来实现链表的倒序输出
    public static void printListReverseByStack(ListNode headNode){
        //初始化栈
        Stack<ListNode> stack=new Stack<>();
        while (headNode != null){
            stack.add(headNode);
            headNode=headNode.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().value);
        }
    }

    //用递归的方法实现
    public static void printListReverseByRecursion(ListNode headNode){
        if (headNode==null){
            return;
        }
        printListReverseByRecursion(headNode.next);
        System.out.println(headNode.value);
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode();
        ListNode node2=new ListNode();
        ListNode node3=new ListNode();
        node1.value=1;
        node2.value=2;
        node3.value=3;
        node1.next=node2;
        node2.next=node3;
        node3.next=null;
        //printListReverseByStack(node1);//栈
        printListReverseByRecursion(node1);//递归
    }
}

/**
 * 定义链表结构
 */
class ListNode {
    int value;
    ListNode next;
}