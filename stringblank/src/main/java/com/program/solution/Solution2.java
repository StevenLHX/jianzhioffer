package com.program.solution;

/**
 *  将字符串中的空格替换为%20
 */
public class Solution2 {
    /**
     * @param c  输入的带空格的字符数组
     * @param length  第一个字符到最后一个字符的长度，不是字符数组的长度
     * @return
     */
    public static String replaceSpace(char[] c,int length){
        //查询空格个数
        int count=0;
        for (int i=0;i<length;i++){
            if (c[i]==' '){
                count++;
            }
        }
        //重新计算新数组的大小
        int newLength=length+count*2;
        //从尾到头查找
        int i=length-1;
        int j=newLength-1;
        while (i>=0&&j>=i){
            if (c[i]==' '){
                c[j--]='0';
                c[j--]='2';
                c[j--]='%';

            }else {
                c[j--]=c[i];
            }
            i--;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String str="We are happy";
        int length=str.length();
        char[] olderArray=str.toCharArray();

        char[] newArray=new char[100];
        for (int i=0;i<olderArray.length;i++){
            newArray[i]=olderArray[i];
        }
        String resultStr = replaceSpace(newArray, length);
        System.out.println(resultStr);
    }
}
