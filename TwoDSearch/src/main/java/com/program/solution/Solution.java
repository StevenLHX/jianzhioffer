package com.program.solution;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */
public class Solution {
    public static boolean find(int arr[][],int number){
        boolean flag=false;
        if (arr!=null&&arr.length!=0){
            int rows=arr.length;//行数
            int columns=arr[0].length;//列数
            //当前行和列
            int row=0;
            int column=columns-1;
            while (row<=rows-1&&column>=0){
                //比较二维数组中元素与number的关系
                if (arr[row][column]==number){
                    flag=true;
                    break;
                }else if(arr[row][column]>number){
                    column--;
                }else {
                    row++;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean flag=find(array,11);
        System.out.println(flag);
    }
}
