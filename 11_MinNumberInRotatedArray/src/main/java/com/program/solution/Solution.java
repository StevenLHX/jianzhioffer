package com.program.solution;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class Solution {
    public static Integer min(int[] array){
        if (array==null||array.length==0){
            return null;
        }

        int low=0;
        int high=array.length-1;
        int mid=low;

        //如果能进入此循环说明当前还是旋转数组
        while (array[low]>=array[high]){
            if (high-low==1){
                mid=high;
                break;
            }

            mid=(low+high)/2;
            /*如果low、high、mid三者指向的数字相等，只能顺序查找
              因为我们无法判断中间数是属于第一个递增子数组还是属于第二个递增子数组*/
            if (array[low]==array[mid]&&array[high]==array[mid]){
                return midInOrder(array);
            }

            if (array[mid]>=array[low]){
                low=mid;
            }else if (array[mid]<=array[high]){
                high=mid;
            }
        }
        return array[mid];
    }

    private static Integer midInOrder(int[] array) {
        int min=array[0];
        for (int i=0;i<array.length;i++){
            if (array[i]<min){
                min=array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array={3,4,5,1,2};
        Integer result=min(array);
        System.out.println(result);
    }
}
