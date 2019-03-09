package com.program.solution;

import java.util.Arrays;

/**
 * 方法二：时间复杂度为O(nlogk)的算法，特别适用处理海量数据
 *
 * 我们可以先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。
 * 如果容器中已有数字少于k个，则直接把这次读入的整数放入容器中；如果容器中已有k个数字了，也就是容器已满，
 * 此时我们不能再插入新的数字了而只能替换已有的数字。找出这已有的k个数中的最大值，
 * 然后拿这次待插入的整数和最大值进行比较。如果待插入的值比当前已有的最小值小，则用这个数替换当前已有的最大值；
 * 如果待插入的值比当前已有的最大值还大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
 *
 * 因此当容器满了之后，我们要做3件事；一是在k个整数中找到最大数；二是有可能在这个容器中删除最大数；
 * 三是有可能要插入一个新的数字。如果用一个二叉树来实现这个容器，那么我们能在O(logk）时间内实现这三步操作。
 * 因此对于n个输入的数字而言，总的时间效率是O(nlogk).
 *
 * 我们可以选择用不同的二叉树来实现这个数据容器。由于每次都需要找到k个整数中的最大数字，我们很容易想到用最大堆。
 * 在最大堆中，根节点的值总是大于它的子树中的任意结点的值。
 * 于是我们每次可以在O(1）得到已有的k个数字中的最大值，但需要O(logk)时间完成删除及插入操作。
 */
public class GetKLeastNumbers2 {
    public static void getLeastNumbers2(int[] arr,int k){
        if (arr==null||k<0||k>arr.length){
            return;
        }
        //根据输入数组前k个数建立最大堆
        //从k+1个数开始与根节点比较
        //大于根节点，舍去
        //小于，取代根节点，重建最大堆
        int[] kArray= Arrays.copyOfRange(arr,0,k);
        heapSort(kArray);
        for (int i=k;i<arr.length;i++){
            if (arr[i]<kArray[k-1]){
                kArray[k-1]=arr[i];
                heapSort(kArray);
            }
        }
        for (int i:kArray){
            System.out.print(i+" ");
        }
    }

    //调整堆。使得堆顶为最大值，叶子节点都为最小值，
    // 然后用叶子节点的值（从右往左）依次替换堆顶，同时把堆顶的值移除。
    public static void heapSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            buildMaxHeap(arr,arr.length-i-1);
            swap(arr,0,arr.length-i-1);
        }
    }

    //新建大顶堆。堆顶为最小值，下面依次增大，叶子节点都是最大值，类似于冒泡排序
    public static void buildMaxHeap(int[] arr,int lastIndex){
        for (int i=(lastIndex-1)/2;i>=0;i--){
            int k=i;
            while (2*k+1<=lastIndex){
                int biggerIndex=2*k+1;
                if (biggerIndex<lastIndex){
                    if (arr[biggerIndex]<arr[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if (arr[k]<arr[biggerIndex]){
                    swap(arr,k,biggerIndex);
                    k=biggerIndex;
                }else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr= {4,5,1,6,2,7,3,8};
        getLeastNumbers2(arr,4);
    }
}
