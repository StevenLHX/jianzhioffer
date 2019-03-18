/**
 * 0`n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在0~n-1之内。
 * 在范围0~n-1内的n个数字有且只有一个不在数组中，找出该数字。
 *
 * 思路：
 * 遇到有序数组中的查找，往往要想到二分，因为能把复杂度降到O(logn)
 * data[index_mid] = data_mid
 * 1、若 index_mid = data_mid，则要找的数字在右半段
 * 2、(a) 若 index_mid != data_mid 且 data[index_mid - 1] = index_mid - 1，
 *      也就是当前索引与值不等，但上一个索引与数值相等，则index_mid就是我们要找的数字
 * 　 (b) 若 index_mid != data_mid 且 data[index_mid - 1] != index_mid - 1，那么我们要找的数字在左半段
 */
public class MissingNumber {
    public static int getMissNumber(int[] array){
        if (array==null|array.length<=0){
            return -1;
        }
        int start=0;
        int end=array.length-1;
        while (start<=end){
            int midIndex=(start+end)/2;
            int midData=array[midIndex];
            if (midIndex!=midData){
                if (array[midIndex-1]==midIndex-1||midIndex==0){//处理了0不在数组里
                    return midIndex;
                }else {
                    end=midIndex-1;
                }
            }else {
                start=midIndex+1;
            }
        }
        //很关键，比如 0 1 2 3 4,每个数字都是对应相等，此时start=5,因此5是要找的数字
        if (start==array.length){
            return array.length;
        }
        return -1;// 无效的输入，如数组不是递增，输入数字不在范围
    }

    public static void main(String[] args) {
        int[] array={0,1,2,3,5,6,7,8};
        System.out.println(getMissNumber(array));
    }
}
