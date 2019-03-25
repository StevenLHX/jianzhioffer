/**
 * n个骰子的点数
 *
 * 把N个骰子扔在地上，所有骰子朝上一面的点数之和为S。
 * 输入N，打印出S的所有可能的值出现的概率。
 */
public class DicesProbability {
    private static final int g_maxValue=6;//出现最大的点数
    //TODO n个骰子的点数（递归法，不懂）
    public static void printProbability(int number){
        if (number<1){
            return;
        }
        int maxSum=number*g_maxValue;
        int[] pProbabilities=new int[maxSum-number+1];
        //初始化，开始统计之前都为0次
        for (int i=number;i<=maxSum;i++){
            pProbabilities[i-number]=0;
        }
        double total=Math.pow(g_maxValue,number);
        //probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        probability(number,pProbabilities);
        for (int i=number;i<=maxSum;i++){
            double ratio=pProbabilities[i-number]/total;
            System.out.println("i:"+i+" ratio:"+ratio);
        }

    }
    public static void probability(int number,int[] pProbabilities){
        for (int i=1;i<=g_maxValue;i++){//从第一个骰子开始
            probability(number,number,i,pProbabilities);
        }
    }
    //总共original个骰子，当前第current个骰子，当前的和，贯穿始终的数组。
    private static void probability(int original, int current, int sum, int[] pProbabilities) {
        if (current==1){
            pProbabilities[sum-original]++;
        }else {
            for (int i=1;i<=g_maxValue;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }

}
