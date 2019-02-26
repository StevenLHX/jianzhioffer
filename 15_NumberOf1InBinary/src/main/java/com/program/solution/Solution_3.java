package com.program.solution;

/**
 * 能给面试官带来惊喜的解法
 *
 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0。
 * 那么一个整数的二进制表示中有多少个1，就可以进行多少次运算。
 *
 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变为0
 */
public class Solution_3 {
    public static int fun(int num){
        int count=0;
        while (num!=0){
            count++;
            num=(num-1)&num;
        }
        return count;
    }

    public static void main(String[] args) {
        int num=9;
        System.out.println(fun(num));
    }
}
