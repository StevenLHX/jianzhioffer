/**
 * 在排序数组中查找数字
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class NumberOfK {
    //自己写的方法，效率可能有点低
    public static int countOfK(int[] array,int key){
        boolean flag=true;//判断是否有效。当数组不符合规定时返回0与符合时的0加以区分
        if (array==null||array.length<=0){
            flag=false;
            return 0;
        }

        int count=0;
        int start=0;
        int end=array.length-1;
        int mid=(start+end)/2;

        for (int i=mid;i>=0;i--){
            if (array[i]==key){
                count++;
                continue;
            }
        }
        for (int j=mid+1;j<array.length;j++){
            if (array[j]==key){
                count++;
                continue;
            }
        }
        System.out.println(flag);
        return count;
    }


    public static void main(String[] args) {
        int[] array={1,2,3,3,3,3,4,5};
        System.out.println(countOfK(array, 3));
        System.out.println(getCountOfK(array,3));//方法二
    }

    //方法二
    public static int getCountOfK(int[] array,int key){
        int count=0;
        if (array!=null&&array.length>0){
            int first=getFirstK(array,key,0,array.length-1);
            int last=getLastK(array,key,0,array.length-1);
            if (first>-1&&last>-1){
                count=last-first+1;
            }
        }
        return count;
    }
    public static int getFirstK(int[] array,int key,int start,int end){
        if (start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        //如果中间值等于k
        if (midData==key){
            if ((midIndex>0&&array[midIndex-1]!=key)||midIndex==0){//如果中间值的前一个数不为k或者中间值是第一个数
                return midIndex;
            }else {//中间值的前一个数为k，则第一个k还在当前值的左边
                end=midIndex-1;
            }
        }
        //中间值大于k，说明第一个k在中间值左边
        else if (midData>key){
            end=midIndex-1;
        }
        //如果中间值小于k，说明第一个k在中间值右边
        else {
            start=midIndex+1;
        }
        return getFirstK(array,key,start,end);
    }
    public static int getLastK(int[] array,int key,int start,int end){
        if (start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        if (midData==key){
            if (midIndex<array.length-1&&array[midIndex+1]!=key){
                return midIndex;
            }else {
                start=midIndex+1;
            }
        }else if (midData<key){
            start=midIndex+1;
        }else {
            end=midIndex-1;
        }
        return getLastK(array,key,start,end);
    }
}
