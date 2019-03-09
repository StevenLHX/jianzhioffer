package com.program.solution;

/**
 * 最小的k个数
 *
 * 输入n个整数，找出其中最小的k个数。
 * 例如输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字是1，2，3，4。
 */
public class GetKLeastNumbers {
    /**
     * 方法一：利用partition，
     * 这会修改输入的数组，因为partition会调整数组中数字的顺序
     */
    public static int[] getLeastNumbers(int arr[],int k){
        if (arr==null||arr.length==0){
            return null;
        }
        int[] result=new int[k];
        int start=0;
        int end=arr.length-1;
        int index=partition(arr,arr.length,start,end);
        while (index!=k-1){
            if (index>k-1){//start，index-1  左边递归使其排序
                end=index-1;
                index=partition(arr,arr.length,start,end);
            }else {//index+1,end  右边递归使其排序
                start=index+1;
                index=partition(arr,arr.length,start,end);
            }
        }
        for (int i=0;i<=k-1;i++){
            result[i]=arr[i];
        }
        return result;
    }

    //该方法将大于基准数的放右边，小于基准数的放左边。两边不排序
    public static int partition(int[] arr,int length,int start,int end){
        if (arr==null||length<=0||start<0||end>=length){
            throw new RuntimeException("输入参数无效");
        }
        //产生0-(length-1)的整数值，也是数组的索引.
        int index= (int) (Math.random()*length);
        swap(arr,index,start);
        //基准数的值
        int pointNum=arr[start];
        int i=start;//[start+1,j]小于中间数  [j+1,end]大于中间数
        for (int j=start+1;j<=end;j++){
            if (arr[j]<pointNum){
                i++;
                swap(arr,i,j);
            }
        }
        //交换中间数
        swap(arr,i,start);
        return i;
    }

    private static void swap(int[] arr, int index, int start) {
        int temp=arr[index];
        arr[index]=arr[start];
        arr[start]=temp;
    }

    public static void main(String[] args) {
        int[] arr={4,5,1,6,2,7,3,8};
        int[] resultNums = getLeastNumbers(arr, 4);
        for (int i=0;i<4;i++){
            System.out.print(resultNums[i]+" ");
        }
    }
}
