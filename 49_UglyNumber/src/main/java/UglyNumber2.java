/**
 * 方法二：用空间换时间
 * 根据丑数的定义，我们可以知道丑数可以由另外一个丑数乘以2，3或者5得到。
 * 因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2，3或者5得到的。
 *
 * 我们把得到的第一个丑数乘以2以后得到的大于M的结果记为M2。
 * 同样，我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。
 * 那么M后面的那一个丑数应该是M2,M3和M5当中的最小值：Min(M2,M3,M5)。
 * 比如将丑数数组中的数字按从小到大乘以2，直到得到第一个大于M的数为止，那么应该是2*2=4<M，3*2=6>M，所以M2=6。
 * 同理，M3=6，M5=10。所以下一个丑数应该是6。
 */
public class UglyNumber2 {
    public static int getUglyNumber(int index){
        if (index<=0){
            return 0;
        }
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        int nextUglyIndex=1;

        int multiply2=0;
        int multiply3=0;
        int multiply5=0;
        int min=0;

        while (nextUglyIndex<index){
            min=min(uglyNumbers[multiply2]*2,uglyNumbers[multiply3]*3,uglyNumbers[multiply5]*5);
            uglyNumbers[nextUglyIndex]=min;
            while (uglyNumbers[multiply2]*2<=uglyNumbers[nextUglyIndex]){
                multiply2++;
            }
            while (uglyNumbers[multiply3]*3<=uglyNumbers[nextUglyIndex]){
                multiply3++;
            }
            while (uglyNumbers[multiply5]*5<=uglyNumbers[nextUglyIndex]){
                multiply5++;
            }
            nextUglyIndex++;
        }
        int result = uglyNumbers[index - 1];
        uglyNumbers=null;
        return result;
    }
    private static int min(int num1,int num2,int num3){
        int min=num1<num2?num1:num2;
        min=min<num3?min:num3;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(8));
        System.out.println(getUglyNumber(1500));
    }
}
