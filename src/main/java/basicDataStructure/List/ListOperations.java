/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package basicDataStructure.List;

/**
 *  链表的基本操作
 *
 *
 * @author wb-ywh474663
 * @version $Id: ListOperations.java, v 0.1 2018年11月27日 22:52 wb-ywh474663 Exp $
 */
public class ListOperations {

    /**
     * 从尾到头打印链表
     * 自然想到用栈，用栈自然想到用递归，除非明确要求用递归，自然栈的鲁棒性好
     * @param head
     */
    public static void printReverse(Node head){


    }

    /**
     * 剑指Offer 面试题25:
     * 注意鲁棒性，防御性编程的习惯要养成
     * 知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static Node mergeOrderLists(Node pHead1, Node pHead2){
        //注意边界条件
        if(pHead1 == null && pHead2 == null){
            return null;
        }else if(pHead1 == null && pHead2 != null){
            return pHead2;
        }else if(pHead1 != null && pHead2 == null){
            return pHead1;
        }else{
            Node mergeHead;
            Node temp;
            //两个链表都不为空：
            if(pHead1.val <= pHead2.val){
                mergeHead = pHead1;
                temp = pHead1;
                pHead1 = pHead1.next;
            }else{
                mergeHead = pHead2;
                temp = pHead2;
                pHead2 = pHead2.next;
            }
            while(pHead1 != null && pHead2 != null){
                if(pHead1.val <= pHead2.val){
                    temp.next = pHead1;
                    temp = temp.next;
                    pHead1 = pHead1.next;
                }else{
                    temp.next = pHead2;
                    temp = temp.next;
                    pHead2 = pHead2.next;
                }
            }
            if(pHead1 == null && pHead2 != null){
                temp.next = pHead2;
            }else if(pHead1 != null && pHead2 == null){
                temp.next = pHead1;
            }else{
                temp.next = null;
            }
            return mergeHead;

        }
    }

    /**
     * 判断两个单链表是否相交
     */
    public static boolean isIntersect(Node head1, Node head2){
        int head1Size = countListLength(head1);
        int head2Size = countListLength(head2);
        if(head1Size == 0 || head2Size == 0){
            return false;
        }
        Node tempHead1 = head1;
        Node tempHead2 = head2;
        int diff;
        if(head1Size <= head2Size){
            diff = head2Size - head1Size;
            while(diff > 0){
                tempHead2 = tempHead2.next;
                diff--;
            }
        }else{
            diff = head1Size - head2Size;
            while(diff > 0){
                tempHead1 = tempHead1.next;
                diff--;
            }
        }
        while(tempHead1 != null && tempHead2 != null){
            if(tempHead1 != tempHead2){
                tempHead1 = tempHead1.next;
                tempHead2 = tempHead2.next;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 求两个单链表相交的第一个节点
     */
    public static Node getFirstCommonNode(Node head1, Node head2) {
        int head1Size = countListLength(head1);
        int head2Size = countListLength(head2);
        if(head1Size == 0 || head2Size == 0){
            return null;
        }
        Node tempHead1 = head1;
        Node tempHead2 = head2;
        int diff;
        if(head1Size <= head2Size){
            diff = head2Size - head1Size;
            while(diff > 0){
                tempHead2 = tempHead2.next;
                diff--;
            }
        }else{
            diff = head1Size - head2Size;
            while(diff > 0){
                tempHead1 = tempHead1.next;
                diff--;
            }
        }
        while(tempHead1 != null && tempHead2 != null){
            if(tempHead1 != tempHead2){
                tempHead1 = tempHead1.next;
                tempHead2 = tempHead2.next;
            }else{
                return tempHead1;
            }
        }
        return null;

    }

    /**
     * 判断一个单链表中是否有环, 快慢指针
     */
    public static boolean hasCycle(Node head) {

        if(head == null){
            return false;
        }
        if(head.next == null){
            return  false;
        }
        Node fast = head;
        Node slow = head;
        //有环的话，逻辑上是走不到尾部的，因为没有尾部，是环
        while(fast != null && slow != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = fast.next;
            }

            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    /**
     * 判断一个单链表中是否有环, 快慢指针，如果有环，返回快慢指针第一次相遇点
     */
    public static Node getCircleNode(Node head) {

        if(head == null){
            return null;
        }
        if(head.next == null){
            return  null;
        }
        Node fast = head;
        Node slow = head;
        //有环的话，逻辑上是走不到尾部的，因为没有尾部，是环
        while(fast != null && slow != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = fast.next;
            }

            if(slow == fast){
                return slow;
            }
        }
        return null;
    }

    /**
     * 剑指Offer 面试题23：
     * 书中的思路还有一些不同，确认环存在后，先算出环的长度n，然后两个指针
     * 隔n移动，碰到的点就是环入口，反而麻烦了，
     *
     * 其实可以发现，如果环有n个节点，链表有m个节点，入口不就是m-n对应的节点嘛，
     * 但主要m不知道，遍历一遍又不划算，所以不能这么做
     *
     * 求进入环中的第一个节点
     * 逻辑推是可以的，但是快速思考是利用最小数据量具体量化预演一遍，这样最容易理清楚思路
     */
    public static Node getFirstNodeInCycle(Node head) {

        //首先要确认有没有环，尽管这个方法的前提应该是有环的，但没环也要能处理
        Node circle =  getCircleNode(head);
        if(circle == null){
            return null;
        }
        Node start = head;
        //已经判断有环了
        while(true){
            if(start != circle){
                start = start.next;
                circle = circle.next;
            }else {
                return start;
            }
        }
    }

    /**
     *  给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted: delete
     *  这样写其实还不够，因为两种边界情况没有考虑到
     *  1 只有一个节点，head == toDelete
     *  2 toDelete是尾节点，这个时候只能从头遍历
     */
    public static void delete(Node head, Node toDelete){
            //这是个思维陷阱，其实删的不是这个节点本身，而是下一个结点，把后面的值复制到要删除节点上
            Node next = toDelete.next;
            toDelete.val = next.val;
            toDelete.next = next.next;
    }


    /**
     * 剑指Offer 面试题 24： 链表反转
     * 2019/01/
     * 这题要重新检查一下鲁棒性
     *
     * 此外，递归的思路也写一下
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head){

        if(head == null ){
            return null;
        }
        Node newHead = head;
        head = head.next;
        newHead.next = null;
        while (head != null){
            Node temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;

    }

    public static void printList(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
       while(temp != null){
           System.out.print(temp.val);
           System.out.print(" ");
           temp = temp.next;
       }
       System.out.println();
    }

    /**
     * 获取某个链表的长度， 注意不要改变链表头的指针
     * @param head
     * @return
     */
    public static int countListLength(Node head){
        if(head == null){
            return 0;
        }
        Node temp = head;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 删除有序链表中重复的节点
     * 比如 1-2-3-3-4-4-5
     * 删除后变成 1-2-5
     *
     * 思路： 条件1: 如果node1.val != node2.val, 那么deleteDuplicate(node1) 就是deleteDuplicate(node2)
     *       条件2: 如果node1.val == node2.val，那就要往后找到满足条件1的情况
     * @param head
     * @return
     */
    public static Node deleteDuplicate(Node head){
        /** 空链表 */
        if(head == null){
            return null;
        }
        /** 单个节点链表 */
        if(head.next == null){
            return head;
        }

        Node p1 = head;
        Node p2 = head.next;
        if(p1.val != p2.val){
            p1.next = deleteDuplicate(p2);
            return p1;
        }
        /** p1.val == p2.val   */
        while(p2.next != null){
            p2 = p2.next;
            if(p1.val != p2.val){
                return deleteDuplicate(p2);
            }
        }
        return null;
    }

    /**
     * 剑指Offer 22题： 链表中倒数第k个节点 k从1开始算
     * 注意几点： 1 鲁棒性
     *          2 链表只能遍历一遍，怎么实现：使用两个指针，这个思路很常见
     *
     * @param head
     * @return
     */
    public static Node findKthToTail(Node head){

        return null;

    }

    /**
     * 求链表的中间节点，如果链表中的节点总是是奇数，则返回中间节点，如果节点总是是偶数，则返回中间两个节点中的任意一个
     * 思路同样是两个指针遍历
     * 注意鲁棒性
     * @param head
     * @return
     */
    public static Node findMiddle(Node head){

        return null;
    }

    public static void main(String[] args){

        Node head = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(19);
        Node node3 = new Node(19);
        Node node4 = new Node(17);
        Node node5 = new Node(32);
        Node node6 = new Node(32);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        Node result = deleteDuplicate(head);
        printList(result);

        /*
        Node head2 = new Node(1);
        Node node21 = new Node(5);
        Node node22 = new Node(8);
        head2.next = node21;
        node21.next = node22;

        Node head3 = new Node(1);
        Node node31 = new Node(5);
        Node node32 = new Node(8);
        head3.next = node31;
        node31.next = node32;
        node32.next = node5;

        Node headCircle = new Node(1);
        Node nodeCircle1 = new Node(2);
        Node nodeCircle2 = new Node(9);
        Node nodeCircle3 = new Node(19);
        Node nodeCircle4 = new Node(29);
        Node nodeCircle5 = new Node(39);
        Node nodeCircle6 = new Node(49);

        headCircle.next = nodeCircle1;
        nodeCircle1.next = nodeCircle2;
        nodeCircle2.next = nodeCircle3;
        nodeCircle3.next = nodeCircle4;
        nodeCircle4.next = nodeCircle5;
        nodeCircle5.next = nodeCircle6;
        nodeCircle6.next = nodeCircle3;

        printList(head);
        //printList(head2);
        printList(head3);
        //Node newHead = reverse(head);
        //printList(newHead);
        //Node mergeResult = mergeOrderLists(head,head2);
        //printList(mergeResult);
        boolean result =  isIntersect(head,head3);
        System.out.println(result);
        Node intersectNode = getFirstCommonNode(head,head3);
        System.out.println("第一个相交结点为:" + intersectNode.val);
        Boolean isCircle = hasCycle(headCircle);
        System.out.println("是否相交:" + isCircle);
        Node firstCircleNode = getFirstNodeInCycle(headCircle);
        System.out.println("环第一个节点：" + firstCircleNode.val);


        delete(head,node3);
        printList(head);
        */



    }

}

// 建立链表结构类 val和next
class Node {

    int  val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}


