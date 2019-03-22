/**
 * 数组中只出现一次的两个数字
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class NumbersAppearOnce {
    public void getNumAppearOnce(int[] array){
        int[] num1=new int[1];
        int[] num2=new int[1];
        int length=array.length;
        if (length==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }
        int num=0;
        for (int i=0;i<length;++i){
            num=num^array[i];
        }
        int index=findFirst1(num);
        for (int i=0;i<length;i++){
            if (isBit1(array[i],index)){
                num1[0]=num1[0]^array[i];
            }else {
                num2[0]=num2[0]^array[i];
            }
        }
    }

    //在整数num的二进制表示中找到最右边是1的位
    private int findFirst1(int num){
        int index=0;
        while (((num&1)==0)&&(index<32)){
            num=num>>1;
            index++;
        }
        return index;
    }

    //判断在num的二进制表示中从右边数起的index位是不是1
    private boolean isBit1(int num,int index){
        num=num>>index;
        return (num&1)==1;
    }
}
