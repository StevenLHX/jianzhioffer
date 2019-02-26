package com.program.solution;

/**
 *题目描述：
 * 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],…,k[m]。
 * 请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 分析：
 * 1、求一个问题的最优解；
 * 2、整体的问题的最优解是依赖各个子问题的最优解；
 * 3、把大问题分解成若干个小问题，这些小问题之间还有互相重叠的更小的子问题；
 * 4、为避免子问题的重复计算，我们存储子问题的最优解。从上往下分析问题，从下往上求解问题。
 * 上面的几个条件可以看出，属于动态规划问题。
 *
 * 动态规划：
 * 1、定义函数f(n)表示为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
 * 2、对于第一刀，我们有n-1种可能的选择，可推导出f(n)=max{f(i)*f(n-i)};
 * 3、很明显这是一个从上至下的递归，但是这个递归存在很多重复的计算，所以使用 至下而上的动态规划，
 *    将子问题的最优解保存。
 * 4、注意绳子剪成ix(n-i)和(n-i)xi是相同的；
 * 5、注意不符合切割条件的输入n，以及输入为2、3长度时的结果，因为题中规定m>1。
 */
public class DynamicPlane_fun {
    public static int fun(int length){
        if (length<=1){
            return 0;
        }
        if (length==2){
            return 1;
        }
        if (length==3){
            return 2;
        }

        //TODO 不懂
        //product数组前四个数字用来存储i ，方便后面计算 ;例如f(4) = max[product[2] * product[2]]=4;
        int[] products=new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;

        int max=0;
        for (int i=4;i<=length;i++){
            max=0;
            for (int j=1;j<=i/2;j++){
                if (max<products[j]*products[i-j]){
                    max=products[j]*products[i-j];
                }
                products[i]=max;
            }
        }
        return products[length];
    }

    public static void main(String[] args) {
        int length=8;
        System.out.println(fun(length));
    }
}
