package com.program.solution;

/**
 * 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵：
 * 1， 2， 3， 4
 * 5， 6， 7， 8
 * 9， 10，11，12
 * 13，14，15，16
 * 则依次打印出数字1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10.
 */
public class PrintMatrix {
    //循环打印矩阵
    public void printMatrixClockwisely(int[][] numbers,int columns,int rows){
        if (numbers==null||columns<=0||rows<=0){
            return;
        }
        int start=0;
        while (columns>start*2&&rows>start*2){
            printMatrixInCircle(numbers,columns,rows,start);
            ++start;
        }
    }

    private void printMatrixInCircle(int[][] numbers, int columns, int rows,int start) {
        int endX=columns-1-start;//终止列号
        int endY=rows-1-start;//终止行号
        //从左至右打印一行
        for (int i=start;i<=endX;i++){
            System.out.println(numbers[start][i]+" ");
        }
        //从上到下打印一列
        if (endY>start){
            for (int i=start+1;i<=endY;i++){
                System.out.println(numbers[i][endX]+" ");
            }
        }
        //从右到左打印一行
        if (endY>start&&endX>start){
            for (int i=endX-1;i>=start;i--){
                System.out.println(numbers[endY][i]+" ");
            }
        }
        //从下到上打印一列
        if (endY-1>start&&endX>start){
            for (int i=endY-1;i>=start+1;i--){
                System.out.println(numbers[i][start]+" ");
            }
        }
    }
}
