import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中唯一只出现一次的数字
 *
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 */
public class NumberAppearingOnce {
    //这个方法对数组的顺序有限制，如果只出现一次的数字在末尾，则可能会出错。两次的可以用
    public static void getNumAppearOnce(int[] array){
        if (array==null||array.length<=0){
            return;
        }
        int[] num1=new int[1];
        int[] num2=new int[1];
        ArrayList<Integer> aList=new ArrayList<>();
        for (int i=0;i<array.length;i++){
            if (!aList.contains(array[i])){
                aList.add(array[i]);
            }else {
                aList.remove(new Integer(array[i]));
            }
        }
        if (aList.size()>0){
            num1[0]=aList.get(0);
            num2[0]=aList.get(1);
        }
        System.out.print(num1[0]+" ");
        System.out.print(num2[0]);
    }

    //hash法
    public static void getNumAppearOnce2(int[] array){
        if (array==null||array.length<=0){
            return;
        }
        Map<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<array.length;i++){
          if (hashMap.containsKey(array[i])){
              hashMap.put(array[i],hashMap.get(array[i])+1);
          }else {
              hashMap.put(array[i],1);
          }
        }
        Set<Integer> sets=hashMap.keySet();
        for (int key:sets){
            if (hashMap.get(key)==1){
                System.out.print(key+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array={2,3,4,2,5,2,3,3};
        getNumAppearOnce(array);
        System.out.println();
        getNumAppearOnce2(array);
    }
}
