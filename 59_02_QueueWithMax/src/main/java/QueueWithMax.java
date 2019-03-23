import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 队列的最大值
 *
 * 请定义一个队列并实现函数max得到队列里的最大值，
 * 要求函数max、push_back和pop_front的时间复杂度都是O(1)。
 * 思路：
 * 与滑动窗口的最大值一题相似，利用一个《双端队列》来存储当前队列里的最大值以及之后可能的最大值。
 * 在定义题目要求功能的队列时，除了定义一个队列data存储数值，
 * 还需额外用一个队列maxmium存储可能的最大值；
 * 此外，还要定义一个数据结构，用于存放数据以及当前的index值，
 * 用于删除操作时确定是否删除maxmium中最大值。
 */
public class QueueWithMax {
    //TODO 队列的最大值（不懂）
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index){
            this.number=number;
            this.index=index;
        }
    }
    private ArrayDeque<InternalData> data=new ArrayDeque<>();//存储数值
    private ArrayDeque<InternalData> maximum=new ArrayDeque<>();//存储可能的最大值

    private int curIndex;

    public void push_back(int number){
        InternalData curData=new InternalData(number,curIndex);
        data.addLast(curData);
        while (!maximum.isEmpty()&&maximum.getLast().number<number){
            maximum.removeLast();
        }
        maximum.addLast(curData);
        curIndex++;
    }

    public void pop_front(){
        if (data.isEmpty()){
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData=data.removeFirst();
        if (curData.index==maximum.getFirst().index){
            maximum.removeFirst();
        }
    }

    public int max(){
        if (maximum==null){
            System.out.println("队列为空，无最大值！");
            return 0;
        }
        return maximum.getFirst().number;
    }

    public static void main(String[] args) {
        QueueWithMax testQueue=new QueueWithMax();
        testQueue.push_back(2);
        System.out.println(testQueue.max()==2);
    }

}
