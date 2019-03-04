package com.program.solution;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min,push及pop的时间复杂度都是O(1).
 */
public class MinInStack {
    //数据栈
    private static Stack<Integer> dataStack=new Stack<>();
    //辅助栈
    private static Stack<Integer> minStack=new Stack<>();

    //进栈
    public static void push(Integer i){
        dataStack.push(i);
        if (minStack.size()==0||i<minStack.peek()){
            minStack.push(i);
        }else {
            minStack.push(minStack.peek());
        }
    }

    //出栈
    public static void pop(){
        assert (dataStack.size()>0&&minStack.size()>0);
        minStack.pop();
        dataStack.pop();
    }

    //最小值
    public static Integer min(){
        assert (dataStack.size()>0&&minStack.size()>0);
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(1);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());
    }
}
