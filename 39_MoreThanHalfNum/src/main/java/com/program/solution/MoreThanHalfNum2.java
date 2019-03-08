package com.program.solution;

/**
 * 方法二：根据数组特点找出时间复杂度为O(N)的算法
 */
public class MoreThanHalfNum2 {
    public static int findTarget22(int[] arr){
        //验证数组是否为空
        if (!checkValidArr(arr)){
            return 0;
        }
        int nlength=arr.length;//数组长度
        int res=arr[0];//基准值
        int times=1;//出现次数
        for (int i=0;i<nlength;i++){
            if (times==0){
                res=arr[i];
            }else if (arr[i]==res){
                times++;
            }else {
                times--;
            }
        }
        //验证数组中是否存在长度超过一半的数字
        if (!checkMoreHalf(arr,res)){
            return 0;
        }
        return res;
    }

    private static boolean checkMoreHalf(int[] arr, int res) {
        boolean exitMoreHalfNum=true;
        int times=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==res){
                times++;
            }
        }
        int midNum=arr.length/2;
        if (times<=midNum){
            exitMoreHalfNum=false;
        }
        return exitMoreHalfNum;
    }

    //验证数组是否为空
    private static boolean checkValidArr(int[] arr) {
        boolean isValid=true;
        if (arr.length<=0){
            isValid=false;
        }
        return isValid;
    }

    public static void main(String[] args) {
        int arr[]= {1,2,3,2,2,2,5,4,2};
        int result = findTarget22(arr);
        System.out.println(result);
    }
}
