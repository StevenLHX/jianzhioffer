import java.util.LinkedList;
import java.util.Vector;

/**
 * 圆圈中最后剩下的数字
 *
 * 0, 1, … , n-1 这 n 个数字排成一个圈圈，
 * 从数字 0 开始每次从圆圏里删除第 m 个数字。
 * 求出这个圈圈里剩下的最后一个数字。
 */
public class LastNumberInCircle {
    /**
     * 方法一：采用链表来存放，每次对长度取余来实现循环
     * @param n
     * @param m
     * @return
     */
    public static int getLastNumInCircle(int n,int m){
        if (m==0||n==0){
            return -1;
        }
        LinkedList<Integer> list=new LinkedList<>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int removeIndex=0;
        while (list.size()>1){
            removeIndex=(removeIndex+m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.getFirst();
    }

    /**
     * 方法二：采用推导出来的方法
     * @param n
     * @param m
     * @return
     */
    public static int getLastNumInCircle2(int n,int m){
        if (n<1||m<1){
            return -1;
        }
        int last=0;
        for (int i=2;i<=n;i++){
            last= (last+m)%i;
        }
        return last;
    }
}