package com.program.solution;

/**
 * 打印1到最大的n位数
 *
 * 输入数字n,按顺序打印出从1到最大的n位十进制数，比如输入3,则打印出1,2,3一直到最大的3位数即999
 */
public class PrintOneToMaxNthDigits1 {
    public static boolean increament(int[] number){
        //最高位产生进位标志
        boolean isOverFlow=false;
        //进位位
        int carry=0;

        for (int i=number.length-1;i>=0;i--){
            int sum=number[i]+carry;
            if (i==number.length-1){
                sum++;
            }
            if (sum>=10){
                if (i==0){
                    isOverFlow=true;
                }else {
                    sum=sum-10;
                    carry=1;
                    number[i]=sum;
                }
            }else {
                number[i]++;
                break;
            }
        }
        return isOverFlow;
    }

    //打印数组中表示的数，如果数组中表示的数字小于n，则不打印前面的0
    public static void print(int[] number){
        //标记：判断是否可以开始打印
        boolean isBeginning=false;
        for (int i=0;i<number.length;i++){
            if (!isBeginning&&number[i]!=0){
                isBeginning=true;
            }
            if (isBeginning){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] number=new int[3];
        while (!increament(number)){
            print(number);
        }
    }
}
