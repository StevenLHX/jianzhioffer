package com.program.solution;

/**
 * 把问题转化成数值排列的解法，递归让代码更简洁：
 * 用数字排列的方法表示：如果我们在数字前面补0的话，就会发现n位所有十进制数其实就是n个从0到9的全排列。
 * 也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。
 * 当然打印的时候，我们应该将前面的0补位去掉。
 */
public class PrintOneToMaxNthDigits2 {
    public void printNumber(StringBuffer sb){
        boolean flag=false;
        for (int i=0;i<sb.length();i++){
            if (!flag&&sb.charAt(i)!='0'){
                flag=true;
            }
            if (flag){
                System.out.print(sb.charAt(i));
            }
        }
        if (flag){
            System.out.println();
        }
    }

    //打印从1到n位的最大数
    public void Print1ToMaxOfNDigits(int n){
        if (n<=0){
            return;
        }
        //初始化数字（用stringbuffer表示）
        StringBuffer sb=new StringBuffer(n);
        for (int i=0;i<n;i++){
            sb.append('0');
        }
        print1ToMaxOfNDigits_Recursely(sb, n, 0);
    }

    private void print1ToMaxOfNDigits_Recursely(StringBuffer sb, int n, int index) {
        if (index==n){
            printNumber(sb);
            return;
        }
        for (int i=0;i<10;i++){
            sb.setCharAt(index, (char) (i+'0'));
            print1ToMaxOfNDigits_Recursely(sb,n,index+1);
        }
    }

    public static void main(String[] args) {
        PrintOneToMaxNthDigits2 test=new PrintOneToMaxNthDigits2();
        test.Print1ToMaxOfNDigits(3);
    }
}
