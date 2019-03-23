import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 */
public class MaxInSlidingWindow {
    /**
     * 借助一个辅助队列，从头遍历数组，根据如下规则进行入队列或出队列操作：
     * 0. 如果队列为空，则当前数字入队列
     * 1. 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空，然后当前数字入队列
     * 2. 如果当前数字小于队列尾，则当前数字入队列
     * 3. 如果队列头超出滑动窗口范围，则删除队列头
     * 这样能始终保证队列头为当前的最大值
     */
    public static ArrayList<Integer> maxInSlidingWindow(int[] array,int size){
        ArrayList<Integer> result=new ArrayList<>();
        if (array==null||array.length==0||size==0||size>array.length){
            return result;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=0;i<array.length;i++){
            if (!queue.isEmpty()){
                //如果队列头元素不在滑动窗口中了，就删除头元素。//注：在队列中存的是数组下标//
                if (i>=queue.peek()+size){
                    queue.pop();
                }
                //如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while (!queue.isEmpty()&&array[i]>=array[queue.getLast()]){
                    queue.removeLast();
                }
            }
            queue.offer(i);//入队列
            //滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if (i+1>=size){
                result.add(array[queue.peek()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array={2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = maxInSlidingWindow(array, 3);
        for (Integer list:result){
            System.out.print(list.intValue()+" ");
        }
    }
}
