/**
 * 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11。
 */
public class MaximalProfit {
    public static int getMaxProfit(int[] numbers){
        if (numbers==null||numbers.length<=0){
            return -1;
        }
        int min=numbers[0];
        int maxProfit=numbers[1]-min;
        for (int i=2;i<numbers.length;i++){
            if (numbers[i-1]<min){
                min=numbers[i-1];
            }
            int currentProfit=numbers[i]-min;
            if (currentProfit>maxProfit){
                maxProfit=currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] numbers={9,11,8,5,7,12,16,14};
        System.out.println(getMaxProfit(numbers));
    }
}
