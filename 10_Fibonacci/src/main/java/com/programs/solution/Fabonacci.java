package com.programs.solution;

/**
 * 斐波那契数列
 * 写一个函数，输入n，求斐波那契数列的第n项。斐波那契数列的定义如下：
 * 循环实现
 */
public class Fabonacci {
    public static int fabonacci(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        int temp1=0;
        int temp2=1;
        int result=0;
        for (int i=2;i<=n;i++){
            result=temp1+temp2;
            temp1=temp2;
            temp2=result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fabonacci(10));
    }
}
