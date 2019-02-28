package com.program.solution;

/**
 * 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串”+100”,”5e2”,”-123”,”3.1416”和”-1E-16”都表示数值。
 * 但是”12e”,”1a3.14”,”1.2.3”,”+-5”和”12e+4.3”都不是。
 */
public class NumberString {
    int index;
    public boolean isNumber(char[] str){
        if (str==null||str.length==0){
            return false;
        }
        index=0;
        boolean flag=scanInteger(str);
        //判断小数部分
        if (index<str.length&&str[index]=='.'){
            index++;
            flag=scanUnsignedInteger(str)||flag;
        }
        //判断指数部分
        if (index<str.length&&(str[index]=='e'||str[index]=='E')){
            index++;
            flag=scanInteger(str)&&flag;
        }
        return index>=str.length&&flag;
    }

    //扫描整数部分
    private boolean scanInteger(char[] str) {
        if (index<str.length&&(str[index]=='+'||str[index]=='-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //扫描无符号整数部分
    private boolean scanUnsignedInteger(char[] str){
        int temp=index;
        while (index<str.length&&str[index]>='0'&&str[index]<='9'){
            index++;
        }
        return index>temp;
    }

    public static void main(String[] args) {
        NumberString test=new NumberString();
        String str="12e+5.4";
        boolean result=test.isNumber(str.toCharArray());
        System.out.println(result);
    }
}
