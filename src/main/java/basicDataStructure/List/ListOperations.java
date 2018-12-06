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
     *求进入环中的第一个节点
     */
    public static Node getFirstNodeInCycle(Node head) {

        return null;


    }

    /**
     *  给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted: delete
     */
    public static void delete(Node head, Node toDelete){


    }


        /**
             * 链表反转
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

    public static void main(String[] args){

        Node head = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(9);
        Node node3 = new Node(19);
        Node node4 = new Node(27);
        Node node5 = new Node(32);
        Node node6 = new Node(41);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

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
        nodeCircle5.next = nodeCircle3;


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


