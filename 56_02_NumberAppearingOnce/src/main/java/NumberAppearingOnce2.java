/**
 * 方法二（推荐）
 *
 * 思路：我们把数组中所有数字的二进制表示的每一位都加起来。
 * 如果某一位的和能被3整除，那么那个只出现一次的数字二进制表示中对应的那一位是0；否则就是1。
 */
public class NumberAppearingOnce2 {
    //TODO 数组中唯一只出现一次的数字（二进制）
    public static int findNumAppearOnce(int[] array){
        if (array==null||array.length<=0){
            throw new RuntimeException("Invalid input");
        }
        int[] bitSum=new int[32];
        for (int num:array){
            int bitMask=1;//位掩膜
            for (int i=bitSum.length-1;i>=0;i--){
                int bit=num&bitMask;
                //位数为1
                if (bit!=0){
                    bitSum[i]+=1;
                }
                bitMask=bitMask<<1;
            }
        }
        int result=0;
        for (int i=0;i<bitSum.length;i++){
            result=result<<1;
            result+=bitSum[i]%3;//要么为0要么为1
        }
        return result;
    }
}
