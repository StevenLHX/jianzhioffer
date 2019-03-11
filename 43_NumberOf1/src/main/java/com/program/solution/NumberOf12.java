package com.program.solution;

/**
 * 方法二：提高时间效率的解法
 *
 * 如果希望不用计算每个数字的1的个数，那就只能寻找1在数字中出现的规律了。
 * 为了找到规律，我们不妨用一个稍微大一点的数字比如21345作为例子来分析。
 * 我们把从1到21345的所有数字分为两段，一段是从1到1345，另一段是从1346到21345.
 * 划分的原因是便于利用递归的思路，因为21345去掉最高位就是1345.我们先看1346到21345中1出现的次数。
 *
 * 1的出现分为两种情况：1出现在最高位和1出现在其他位。
 * 1346到21345，1出现在10000-19999这10000个数字的最高位中，一共出现了10000个，即10^最高位。
 * 我们可以发现一般情况：如果是1346到11345，1出现在10000-11345的最高位中，一共出现2346次，
 * 也就是除去最高数字之后剩下的数字+1，当万位大于1时，1出现在最高位的次数是10^最高位。
 *
 * 接下来分析1出现在除最高位之外的其他四位数中的情况。
 * 1346-21345这20000个数字中后4位出现的次数，分成两段，1346-11345和11346-21345，
 * 每一段剩下的4位数字中，选择其中一位是1，其余三位可以在0-9这10个数字中任意选择，
 * 根据排列组合原则，总共出现次数2*4*10^3=8000次。
 * 我们可以发现一般情况：如果是1346-n1345那么，可以划分为n段，即1出现在除最高位之外的其他四位数的次数是n*4*1000;
 */
public class NumberOf12 {
    public static int numberOf1BetweenAndN(int n){
        if (n<=0){
            return 0;
        }
        String str=n+"";
        return numberOf1(str);
    }

    private static int numberOf1(String str) {
        char[] strN=str.toCharArray();
        int length=strN.length;
        if (length==1&&strN[0]=='0'){
            return 0;
        }
        if (length==1&&strN[0]>1){
            return 1;
        }
        int numFirstDigit=0;
        //计算最高位1的个数
        if (strN[0]>'1'){//最高位不是1的，1的个数。等于10的(length-1)次方
            numFirstDigit= (int) Math.pow(10,length-1);

        }else if (strN[0]=='1'){//最高位是1,1的个数。等于去掉最高位后的数+1

            numFirstDigit=Integer.parseInt(str.substring(1))+1;
        }
        //计算其他位1的个数。(strN[0]-'0')自动将strN[0]转换成double类型
        int numOtherDigits= (int) ((strN[0]-'0')*(length-1)*Math.pow(10,length-2));
        int numRecursive=numberOf1(str.substring(1));
        return numFirstDigit+numOtherDigits+numRecursive;
    }

    public static void main(String[] args) {
        int result = numberOf1BetweenAndN(12);
        System.out.println(result);
    }
}
