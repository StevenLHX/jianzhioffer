/**
 * 数组中数值和下标相等的元素
 *
 * 假设单调递增的数组里每个元素都是整数且都是唯一的。
 * 请实现函数，找出数组中任意一个数值等于其下标的元素。
 * 如{-3,-1,1,3,5}，数字3和下标相等
 * 思路：
 * 若Index = value，则找到
 * 若index > value，在右半段
 * 若index < value，在左半段
 */
public class IntegerIdenticalToIndex {
    public static int getNumberSameAsIndex(int[] array){
        if (array==null||array.length<=0){
            return -1;
        }
        int start=0;
        int end=array.length-1;
        while (start<=end){
            int midIndex=(start+end)/2;
            int midData=array[midIndex];
            if (midData==midIndex){
                return midData;
            }else if (midData>midIndex){
                end=midIndex-1;
            }else {
                start=midIndex+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array={-3,-1,1,3,5};
        System.out.println(getNumberSameAsIndex(array));
    }
}
