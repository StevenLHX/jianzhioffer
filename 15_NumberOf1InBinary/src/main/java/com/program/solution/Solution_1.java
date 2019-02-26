package com.program.solution;
//请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
//例如把9表示成二进制是1001，有2位是1，因此如果输入9，该函数输出2。
/**
 * 可能引起死循环的解法
 *
 * 面试官看了代码后可能会问：把整数右移一位和把整数除以2在数学上是等价的，那上面的代码中可以把右移换成除以2吗？
 * 答案是否定的。因为除法的效率比移位运算要低很多，在实际编程中应尽可能地用移位运算代替乘除法。
 *
 * 面试官会问第二个问题就是：上面的函数如果输入一个负数，比如0x80000000，运行的时候会发生什么情况呢？
 * 把负数0x80000000右移一位的时候，并不是简单地把最高位的1移到第二位变成0x40000000，而是0xC0000000。
 * 这是因为移位前是个负数，仍然保证移位是个负数，因此移位后的最高位会设为1。
 * 如果一直做右移位运算，最终这个数字会变成0xFFFFFFFF而陷入死循环。
 *
 */
public class Solution_1 {
    public static int fun(int num){
        int count=0;
        while (num!=0){
            if ((num & 1)==1){
                count++;
            }
            num=num>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num=9;
        System.out.println(fun(num));
    }
}
