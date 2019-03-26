import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * 随机抽取扑克牌中的5张牌，判断是不是顺子，即这5张牌是不是连续的。
 * 其中A看成1，J看成11，Q看成12，K看成13，大小王可以看成任何需要的数字。
 * 思路：
 * 首先把数组排序，再统计数组中 0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。
 * 如果空缺的总数小于或者等于 0 的个数，那么这个数组就是连续的：反之则不连续。
 * 另外，还需要注意一点： 如果数组中的非 0 数字重复出现，则该数组不是连续的。
 * 换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 */
public class ContinousCards {
    public static boolean isContinuous(int[] numbers){
        if (numbers==null||numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);//排序
        int cnt=0;//0的个数
        for (int num:numbers){
            if (num==0){
                cnt++;
            }
        }
        int ksum=0;//统计排序之后的数组中相邻数字之间的空缺总数
        for (int i=0;i<numbers.length-1;i++){
            int a=numbers[i];
            int b=numbers[i+1];
            if (a==0||b==0){
                continue;
            }
            if (b==a){
                return false;
            }
            ksum+=b-a-1;
        }
        if ((cnt!=0&&ksum==cnt)||ksum==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers={1,0,3,0,5};
        System.out.println(isContinuous(numbers));
    }
}
