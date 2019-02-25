package com.program.solution;

/**
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，
 * 那么对应的输出是重复的数字2或者3。
 *
 * 分析1：
 * 由于不能修改输入的数组，我们可以创建一个长度为n+1的辅助数组，然后逐一把原数组的每个数字复制到辅助数组。
 * 如果原数组中被复制的数字是m，则把它复制到辅助数组中下标为m的位置。如果下标为m的位置上已经有数字了，
 * 则说明该数字重复了。由于使用了辅助空间，故该方案的空间复杂度是O(n)
 */
public class Solution_fuzhu {
    public static int getDuplication(int[] arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        for(int i=0;i<arr.length;i++){
            if (arr[i]<1||arr[i]>=arr.length){
                return -1;
            }
        }
        int[] tempArr=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (arr[i]==tempArr[arr[i]]){
                return arr[i];
            }
            tempArr[arr[i]]=arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nembers={2,1,5,4,3,2,6,7};
        System.out.println(getDuplication(nembers));
    }
}
