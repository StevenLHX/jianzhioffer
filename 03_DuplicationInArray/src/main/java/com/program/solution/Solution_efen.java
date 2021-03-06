package com.program.solution;

/**
 * 分析二：
 * 由于分析一的空间复杂度是O(n)，因此我们需要想办法避免使用辅助空间。我们可以这样想：
 * 如果数组中有重复的数，那么n+1个1~n范围内的数中，一定有几个数的个数大于1。
 * 那么，我们可以利用这个思路解决该问题。
 *
 * 我们把从1~n的数字从中间的数字m分为两部分，前面一半为1~m，后面一半为m+1~n。
 * 如果1~m的数字的数目等于m，则不能直接判断这一半区间是否包含重复的数字，
 * 反之，如果大于m，那么这一半的区间一定包含重复的数字；如果小于m，另一半m+1~n的区间里一定包含重复的数字。
 * 接下来，我们可以继续把包含重复的数字的区间一分为二，直到找到一个重复的数字。
 *
 */
public class Solution_efen {
    public static int getDuplication(int[] arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]<1||arr[i]>=arr.length){
                return -1;
            }
        }

        int start=1;
        int end=arr.length-1;
        int mid=0;
        int count=0;
        while (start<=end){
            if (start==end){
                count=countRange(arr,start,end);
                if (count>1){
                    return start;
                }else{
                    break;
                }
            }
            mid=(start+end)/2;
            count=countRange(arr,start,mid);
            if (count>mid-start+1){
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }

    public static int countRange(int[] arr,int start,int end){
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=start&&arr[i]<=end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers={1,3,5,4,2,5,6,7};
        int result=Solution_efen.getDuplication(numbers);
        System.out.println(result);
    }
}
