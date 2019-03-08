package com.program.solution;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字.
 * 例子说明：如输入一个长度为9的数组｛ 1, 2, 3, 2, 2, 2, 5, 4, 2｝。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2 。
 */
public class MoreThanHalfNum1 {
    /**
     * 方法一：基于partition函数的时间复杂度为O(N)的算法
     * @param arr
     * @return
     */
    public static int findTarget11(int[] arr){
        //验证数组是否为空
        if (!checkValidArr(arr)){
            return 0;
        }
        int nLength=arr.length;
        int target=nLength/2;

        //找到中间数
        int res=findTarget(arr,0,nLength-1,target);

        //验证数组中是否存在长度超过一半的数字
        if (!checkMoreHalf(arr,res)){
            return 0;
        }
        return res;
    }

    private static int findTarget(int[] arr, int start, int end, int target) {
        if (start>=end){
            return arr[start];
        }
        int index=partition(arr,start,end);
        if (index==target){
            target=index;
        }else if (index<target){
            findTarget(arr,index+1,end,target);
        }else {
            findTarget(arr,start,index-1,target);
        }
        return arr[target];
    }

    private static int partition(int[] arr, int start, int end) {
        //随机选择中间数
        int point= (int) (Math.random()*(end-start+1)+1);
        swap(arr,point,start);
        //中间数的值
        int pointNum=arr[start];
        int m=start;//[start+1,n]小于中间数  [n+1,end]大于中间数
        for (int n=start+1;n<=end;n++){
            if (pointNum>arr[n]){
                m++;
                swap(arr,m,n);
            }
        }
        //交换中间数
        swap(arr,start,m);
        return m;
    }

    /**
     * 验证数组中是否存在长度超过一半的数字
     * @param arr
     * @param res
     * @return
     */
    private static boolean checkMoreHalf(int[] arr, int res) {
        boolean exitMoreHalf=true;
        int times=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==res){
                times++;
            }
        }
        //这里其实有歧义，就是对于数组长度的一半如何定义，奇数和偶数是不一样的
        int midNum=arr.length/2;
        if (times<=midNum){
            exitMoreHalf=false;
        }
        return exitMoreHalf;
    }

    /**
     * 验证数组是否为空
     * @param arr
     * @return
     */
    private static boolean checkValidArr(int[] arr) {
        boolean isValid=true;
        if (arr.length<=0){
            isValid=false;
        }
        return isValid;
    }

    private static void swap(int[] arr, int num1, int num2) {
        int tmp=arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=tmp;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        int result = findTarget11(arr);
        System.out.println(result);
    }

}
