/**
 * 和为S的连续整数序列
 *
 * 输入一个正整数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 思路：
 * 可以考虑用两个数small和big分别表示序列的最小值和最大值。
 * 首先把small初始化为1，big初始化为2。
 * 如果从small到big的序列和大于s，可以从序列中去掉最小值，将small的值增大；
 * 如果从small到big的序列和小于s，可以将big值增大，让序列包含新的值。
 * 因为序列至少有两个数字，所以small的值增加到(s+1)/2为止。
 */
public class ContinuousSquenceWithSum {
    public static void findContinuousSequence(int sum) {
        if (sum<3){
            return;
        }
        int small = 1;
        int big = 2;
        int mid=(1 + sum) / 2;
        int curSum=small+big;
        while (small < mid){
            if (curSum== sum) {
                printSequence(small, big);
            }
            while (curSum>sum&&small<mid){
                curSum-=small;
                small++;
                if (curSum==sum){
                    System.out.println();
                    printSequence(small,big);
                }
            }
            big++;
            curSum+=big;
        }
    }
    //打印序列
    private static void printSequence(int small,int big){
        for (int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }
}
