package com.program.solution;

import java.security.InvalidAlgorithmParameterException;

/**
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 */
public class FindGreatestSumOfSubarrays {
    public static boolean invalidInput=false;

    /**
     * 方法一：举例分析数组规律
     * 不适用于全为负数的情况
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubarrays(int[] array){
        if (array==null||array.length==0){
            invalidInput=true;
            return 0;
        }
        //累加的子数组和
        int currentSum=0;
        //最大子数组和
        int greatestSum=0;

        for (int i=0;i<array.length;i++){
            if (currentSum<=0){//如过当前连续n项的和小于等于0,则没必要与后面的元素相加
                currentSum=array[i];//currentSumSum重新赋值
            }else { //如果currentSumSum的值大于0,则继续与后面的元素相加,
                currentSum+=array[i];
            }
            //每次改变currentSumSum的值都有与max进行比较,
            //如果currentSumSum的值大于max,则将currentSumSum的值赋值给max
            if (currentSum>greatestSum){
                greatestSum=currentSum;
            }
        }
        System.out.println(invalidInput);
        return greatestSum;
    }

    /**
     * 方法二：动态规划
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubarrays2(int[] array){
        if (array==null||array.length==0){
            return 0;
        }
        int curSum=array[0];
        int maxSum=array[0];
        for (int i=1;i<array.length;i++){
            curSum=getMax(curSum+array[i],array[i]);
            if (curSum>=maxSum){
                maxSum=curSum;
            }
        }
        return maxSum;
    }

    static int getMax(int a,int b){
        return a>b?a:b;
    }

    //测试
    public static void main(String[] args) {
        int[] array={-1,2,-3,10,-4,7,2,-5};
        int result = findGreatestSumOfSubarrays(array);//方法1结果
        int result2 = findGreatestSumOfSubarrays2(array);//方法2结果
        System.out.println(result);
        System.out.println(result2);
    }

}
