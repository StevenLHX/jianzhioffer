package com.program.solution;

/**
 * 方法二：使用循环实现
 */
public class MaxValueOfGifts2 {
    public static int getMaxValue(int[][] array){
        if (array==null||array.length==0){
            return 0;
        }
        int rows=array.length;
        int cols=array[0].length;
        int[] maxValue=new int[cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int left=0;
                int up=0;
                if (i>0){
                    left=maxValue[j];
                }
                if (j>0){
                    up=maxValue[j-1];
                }
                maxValue[j]=Math.max(up,left)+array[i][j];
            }
        }
        return maxValue[cols-1];
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 },
                { 3, 7, 16, 5 } };
        System.out.println(getMaxValue(arr));
    }
}
