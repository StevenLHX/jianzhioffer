package com.program.solution;

import java.util.Objects;
import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1，2，3，4，5是某栈的压栈序列，
 * 序列4，5，3，2，1是该压栈序列对应的一个弹出序列，但4，3，5，1，2就不可能是该压栈序列的弹出序列。
 */
public class StackSequence {
    public static boolean isPopOrder(int[] pushA,int[] popA){
        Stack<Integer> stack=new Stack<>();
        if ((pushA==null&&popA==null)||(pushA.length==0&&popA.length==0)){
            return false;
        }
        int pushLength=pushA.length;
        int popLength=popA.length;
        int i=0;
        int j=0;
        while (i<pushLength&&j<popLength){
            stack.push(pushA[i]);//先压入一个元素到栈
            while (!stack.isEmpty()&& Objects.equals(popA[j],stack.peek())){
                stack.pop();//相等则弹出
                j++;//弹出序列后移
            }
            i++;//压栈序列继续向后移
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        boolean result = isPopOrder(pushA, popA);
        System.out.println(result);
    }
}
