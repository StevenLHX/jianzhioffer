package com.program.solution;

/**
 * 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印由字符a,b,c所能排列出来的所有字符串：abc,acb,bac,bca,cab,cba
 */
public class StringPermutation {
    public static void permutation(char[] arr,int begin){
        if (begin==arr.length-1){
            String result=new String(arr);
            System.out.println(result);
        }else {
            //包括自己跟自己交换
            for (int i=begin;i<arr.length;i++){
                swap(arr,begin,i);
                //递归求后面的字符的排列
                permutation(arr,begin+1);
                //由于前面交换了一下，所以arr的内容改变了，我们要还原回来
                swap(arr,begin,i);
            }
        }
    }

    //交换位置
    public static void swap(char[] arr,int index1,int index2){
        char temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    public static void main(String[] args) {
        String str="abc";
        char[] arr=str.toCharArray();
        permutation(arr,0);
    }
}
