package com.program.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class StreamMedian {
    private int count=0;//记录数据容器中的元素个数
    //利用优先级队列实现小顶堆，PriorityQueue默认会对入队的元素进行排序，所以在队列顶端的总是最小的元素
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    //利用优先级队列实现大顶堆，根据指定的比较器comparator来排序其元素，所以在队列顶端的总是最大的元素
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        //这个方法是进行排序的类。>=1 升序；<=-1 降序；=0 重复，不记录
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void Insert(Integer num){
        if (count%2==0){//当数据总是为偶数时，新加入的元素，应当进入小根堆
            // （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆,
            //用于保证小顶堆中的最小的元素都比大顶堆中最大的元素还要大）

            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();//筛选出大顶堆中最大元素

            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);

        }else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            // （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最小元素进入大根堆）
            // 用于保证小顶堆中的最小的元素都比大顶堆中最大的元素还要大

            // 1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMaxNum = minHeap.poll();

            // 2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMaxNum);

        }
        count++;
    }

    public Double getMedian(){
        if (count%2==0){
            return new Double((minHeap.peek()+maxHeap.peek()))/2;
        }else {
            return new Double(minHeap.peek());
        }
    }
}
