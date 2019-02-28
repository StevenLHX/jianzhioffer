package com.program.solution;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class OddEventArray {
    public void reorderOddEvent(int[] array){
        if (array==null||array.length==0){
            return;
        }
        int low=0;
        int high=array.length-1;
        while (low<=high){
            while (isEvent(array[low])==false&&low<=array.length-1){
                low++;
            }
            while (isEvent(array[high])==true&&high>=0){
                high--;
            }
            if (low<=high){
                int temp=array[low];
                array[low]=array[high];
                array[high]=temp;
            }
        }
    }

    //判断奇偶性 0为偶数，1为奇数  这里：偶数为true，奇数为false
    private boolean isEvent(int number) {
        return (number&1)==0;
    }

    public static void main(String[] args) {
        OddEventArray test=new OddEventArray();
        int[] array={2,1,3,4,5,6,7,8};
        System.out.println(Arrays.toString(array));
        test.reorderOddEvent(array);
        System.out.println(Arrays.toString(array));
    }
}
