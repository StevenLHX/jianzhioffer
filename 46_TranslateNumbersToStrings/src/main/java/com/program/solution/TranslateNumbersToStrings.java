package com.program.solution;

/**
 * 把数字翻译成字符串
 *
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”…25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumbersToStrings {
    public static int getTranslationCount(int number){
        if (number<0){//负数默认可翻译个数为0
            return 0;
        }
        return translationCount(String.valueOf(number));
    }

    public static int translationCount(String number){
        int length=number.length();
        int[] countRecords=new int[length];
        //只有一个数字，则只有一种翻译方式
        countRecords[length-1]=1;
        int count;
        for (int i=length-2;i>=0;i--){
            count=countRecords[i+1];//f(i+1)
            int digit1=number.charAt(i)-'0';
            int digit2=number.charAt(i+1)-'0';
            int connectedNumber=digit1*10+digit2;//拼接两个数字
            //拼接的数字在10~25范围内
            if (connectedNumber>=10&&connectedNumber<=25){
                if (i<length-2){
                    //f(i)=f(i+1)+f(i+2)
                    count+=countRecords[i+2];
                }else if (i==length-2){
                    count+=1;//拼接的数字只有一种翻译方式
                }
            }
            countRecords[i]=count;
        }
        count=countRecords[0];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(12258));
        System.out.println(getTranslationCount(1253));
    }

}
