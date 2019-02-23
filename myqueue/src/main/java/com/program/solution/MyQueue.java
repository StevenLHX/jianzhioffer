package com.program.solution;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deletedHead,
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class MyQueue {
    public static void main(String[] args) {
        CQueue<Integer> queue=new CQueue<>();
        //进队列
        for (int i=0;i<5;i++){
            queue.appendTail(i);
        }
        //出队列
        for (int i=0;i<5;i++){
            int temp=queue.deleteHead();
            System.out.println(temp+" ");
        }
    }

}
class CQueue<E>{
    private Stack<E> stack1;
    private Stack<E> stack2;

    public CQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    //在队列尾部插入元素，直接在stack1中插入即可
    public void appendTail(E node){
        stack1.push(node);
    }
    //从队列头部删除元素
    public E deleteHead(){
        if (stack2.size()==0){
            if (stack1.size()==0){
                throw new RuntimeException();
            }else {
                while (stack1.size()!=0){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}