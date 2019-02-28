package com.program.solution;

/**
 * 链表中环的入口节点
 *
 * 思路：
 * 1.判断是否存在环，并找到快慢两个指针相遇的位置
 * 2.根据找到的这个相遇位置，统计环中节点的数目n，先让快指针走n步，然后快慢两个指针一起运动，快慢指针相遇时的节点就是环的入口节点
 */
public class EnterNodeInLink {
    public ListNode getEnterNode(ListNode head){
        if (head==null){
            return null;
        }
        //如果有环，第一个和第二个指针在环中相遇时的节点
        ListNode meetingNode=meetingNode(head);
        int ringLength=0;//环的长度
        if (meetingNode!=null){
            ListNode tempNode=meetingNode;
            meetingNode=meetingNode.next;
            while (meetingNode!=tempNode){
                ringLength++;
                meetingNode=meetingNode.next;
            }
            ringLength++;
        }else {
            return null;
        }

        ListNode ahead=head;
        ListNode behind=head;

        while (ringLength>0){
            ahead=ahead.next;
            ringLength--;
        }
        while (ahead!=behind){
            ahead=ahead.next;
            behind=behind.next;
        }
        return behind;
    }

    //在链表存在环的情况下，找到一快一慢两个指针相遇的节点
    private ListNode meetingNode(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode behind=head.next;
        //如果只有一个节点直接返回null
        if (behind==null){
            return null;
        }
        ListNode ahead=head.next;

        while (behind!=null&&ahead!=null){
            if (behind==ahead){
                return ahead;
            }
            behind=behind.next;//behind指针在链表上移动一步
            ahead=ahead.next;  //ahead指针在链表上移动两步
            if (ahead!=null){
                ahead=ahead.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        EnterNodeInLink test = new EnterNodeInLink();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        ListNode resultNode = test.getEnterNode(head);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }

}

class ListNode{
    int value;
    ListNode next;
}
