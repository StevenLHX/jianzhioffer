package com.program.solution;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里面所有的数字拼接排成一个数，打印能拼接出的所有数字中的一个。
 * 例如输入数组｛3，32，321｝，则打印出这3个数字能排成的最小数字321323。
 */
public class SortArrayForMinNumber {
    //TODO 把数组排成最小的数
    public static String printMinNumber(int[] num){
        if (num==null||num.length==0){
            return "";
        }
        int len=num.length;//数组长度
        String[] str=new String[len];//定义字符串数组
        //将整型数组转换成字符串数组
        for (int i=0;i<len;i++){
            str[i]=String.valueOf(num[i]);
        }
        //两两比较大小
        for (int i=0;i<str.length;i++){
            for (int j=i+1;j<str.length;j++){
                if (compare(str[i],str[j])){//如果str[i]与str[j]所组成的新数str[i]str[j]>str[j]str[i]，
                    //即str[i]>str[j]，则返回true，并交换位置
                    String temp=str[j];
                    str[j]=str[i];
                    str[i]=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();//用StringBuilder拼接字符串数组
        for (int i=0;i<str.length;i++){
            sb=sb.append(str[i]);
        }
        return sb.toString();
    }

    public static boolean compare(String s1,String s2){
        int len=s1.length()+s2.length();//s1，s2拼成新数的长度
        String str1=s1+s2;//情况一
        String str2=s2+s1;//情况二
        for (int i=0;i<len;i++){//比较两种情形所组成的数的大小
            if (Integer.parseInt(str1.substring(i,i+1))>Integer.parseInt(str2.substring(i,i+1))){
                return true;
            }
            if (Integer.parseInt(str1.substring(i,i+1))<Integer.parseInt(str2.substring(i,i+1))){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array={3,32,321};
        String result = printMinNumber(array);
        System.out.println(result);
    }
}
