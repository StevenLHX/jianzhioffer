import java.util.ArrayList;
import java.util.List;

/**
 * 和为S的数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，则任意输出一对即可。
 */
public class TwoNumbersWithSum {
    //方法一，效率低。时间复杂度O(n2)
    public static void findTwoNumWithSum(int[] array,int sum){
        if (array==null||array.length<=0){
            return;
        }
        int count=0;
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i]+array[j]==sum){
                    ++count;
                    if (count==1){
                        System.out.println(array[i]+" "+array[j]);
                    }
                }
            }
        }
    }

    //方法二：时间复杂度O(n)
    public static ArrayList<Integer> findTwoNumWithSum2(int[] array,int sum){
        ArrayList<Integer> list=new ArrayList<>();
        if (array==null||array.length<=0){
            return list;
        }
        int i=0;
        int j=array.length-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if (array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6};
        findTwoNumWithSum(array,8);
        ArrayList<Integer> list = findTwoNumWithSum2(array, 8);
        System.out.println(list.get(0)+" "+list.get(1));
    }

}
