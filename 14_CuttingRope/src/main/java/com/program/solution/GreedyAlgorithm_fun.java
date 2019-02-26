package com.program.solution;

/**
 * 贪心算法：
 * 1、贪心算法在对问题求解时，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解；
 * 2、选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关；
 * 3、题目贪心策略：当n>=5时，尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
 */
public class GreedyAlgorithm_fun {
    public static int fun(int length){
        if (length<=1)return 0;
        if (length==2)return 1;
        if (length==3)return 2;

        //尽可能多的剪长度为3的绳子
        int timesOf3=length/3;

        //当绳子最后剩下的长度为4的时候，不能再减去长度为3的绳子段
        //此时，更好的方法就是把绳子剪成长度为2的两段，因为2x2>1x3
        if (length-timesOf3*3==1){
            timesOf3--;
        }
        int timesOf2=(length-timesOf3*3)/2;
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));

    }

    public static void main(String[] args) {
        int length=8;
        System.out.println(fun(length));
    }
}
