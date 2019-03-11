package com.program.solution;

/**
 * 1~n整数中1出现的次数
 *
 * 输入一个整数n，求从1到n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11，和12。一共出现了5次。
 */
public class NumberOf1 {
    //不考虑时间效率的解法
    public static int numberOf1BetweenAndN(int n){
        int number=0;
        for(int i=1;i<=n;i++){
            number+=numberOf1(i);
        }
        return number;
    }

    private static int numberOf1(int i) {
        int number=0;
        while (i!=0){
            if (i%10==1){
                number++;
            }
            i=i/10;
        }
        return number;
    }

    public static void main(String[] args) {
        int result = numberOf1BetweenAndN(12);
        System.out.println(result);
    }
}
