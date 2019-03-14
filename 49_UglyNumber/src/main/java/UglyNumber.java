/**
 * 丑数
 *
 * 我们把只包含因子2,3和5的数称为丑数。
 * 求从小到大的顺序第1500个丑数。
 * 习惯上我们把1当作第一个丑数
 */
public class UglyNumber {
    //方法一：效率低
    public static int getUglyNumber(int index){
        if (index<=0){
            return 0;
        }
        int number=0;
        int uglyFound=0;
        while (uglyFound<index){
            ++number;
            if (isUglyNumber(number)){
                ++uglyFound;
            }
        }
        return number;
    }

    public static boolean isUglyNumber(int number){
        while (number%2==0){
            number/=2;
        }
        while (number%3==0){
            number/=3;
        }
        while (number%5==0){
            number/=5;
        }
        return number==1?true:false;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
    }
}
