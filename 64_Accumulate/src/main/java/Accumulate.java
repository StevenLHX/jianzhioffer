/**
 * 求1+2+...+n
 *
 * 求1+2+3+...+n，要求：
 * 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Accumulate {
    //方法一：利用 && 运算符实现短路结束递归条件
    public static int getSumOf1ToN(int n){
        int result=n;
        //boolean b=判断条件&&待执行语句>0
        boolean value=(n>0)&&((result+=getSumOf1ToN(n-1))>0);
        return result;
    }

    //方法二：利用库函数+位运算：sum=n(n+1)/2
    //有可能不符合题意
    public static int getSumOf1ToN2(int n){
        int sum=(int)(Math.pow(n,2)+n)>>1;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSumOf1ToN(10));
        System.out.println(getSumOf1ToN2(10));
    }
}
