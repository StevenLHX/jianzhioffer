/**
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数：
 * 如数组{7,5,6,4}，逆序对总共有5对，{7,5}，{7,6}，{7,4}，{5,4}，{6,4}；
 *
 * 归并排序的时间复杂度是O（nlohn），比直观的O（n^2）要快，但同时归并排序需要一个长度为n的辅助数组，
 * 相当于用O（n）的空间消耗换来了时间效率的提升，因此这是一种空间换时间的算法。
 */
public class InversePairs {
    public static int inversePairs(int[] data){
        if (data==null||data.length<=1){
            return 0;
        }
        //创建一个辅助数组用于存储排好序的数字
        int[] copy=new int[data.length];
        for (int i=0;i<data.length;i++){
            copy[i]=data[i];
        }

        int count=inversePairs1(data,copy,0,data.length-1);

        return count;
    }

    //指定一个范围，通过递归，对数组进行排序和逆序对的统计
    private static int inversePairs1(int[] data, int[] copy, int start, int end) {
        //如果当前范围内的数字只剩一个，那么重新设置辅助数组的值，并返回逆序对的数量
        if (start==end){
            copy[start]=data[start];
            return 0;
        }
        //定义一个变量用于储存平均值，把范围内的数字分为两部分进行排序与统计
        int mid=(start+end)>>1;

        //统计左右两部分的逆序对
        int left=inversePairs1(data,copy,start,mid)%1000000007;
        int right=inversePairs1(data,copy,mid+1,end)%1000000007;

        //初始化为前半段最后一个数字的下标
        int i=mid;
        //初始化为后半段最后一个数字的下标
        int j=end;

        //辅助数组的下标
        int copyIndex=end;
        //逆序对的计数器
        int count=0;

        //比较数组中左右范的数，找出所有逆序对
        while (i>=start&&j>=mid+1){
            //如果当前左边数组中的值大于当前右边数组中的值，
            //那么当前左边的值肯定大于右边的所有值（因为数组从小到大排列），
            //统计当前右边小于左边的值，并把左边的值放入辅助数组中
            //如果左边的值小于右边的值，那么把右边的大值放入辅助数组中
            if (data[i]>data[j]){
                copy[copyIndex--]=data[i--];
                count+=j-mid;
                if (count>1000000007){
                    count%=1000000007;
                }
            }else {
                copy[copyIndex--]=data[j--];
            }
        }
        //把剩下的没有遍历的数全部放入辅助数组
        for (;i>start;i--){
            copy[copyIndex--]=data[i];
        }
        for (;i>mid;j--){
            copy[copyIndex--]=data[j];
        }
        //拷贝数组，把排好序的数组放入data中，在后面的判断中不会导致顺序出错
        for (i=start;i<=end;i++){
            data[i]=copy[i];
        }

        //返回该范围内逆序对的数量
        return (count+left+right)%1000000007;
    }

    public static void main(String[] args) {
        int[] data={7,5,6,4};
        System.out.println(inversePairs(data));//6？？？
    }
}
