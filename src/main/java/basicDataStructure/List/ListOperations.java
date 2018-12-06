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
        return null;


    }

    /**
     * 判断两个单链表是否相交
     */
    public static boolean isIntersect(Node head1, Node head2){
        return false;

    }

    /**
     * 求两个单链表相交的第一个节点
     */
    public static Node getFirstCommonNode(Node head1, Node head2) {

        return null;

    }

    /**
     * 判断一个单链表中是否有环
     */
    public static boolean hasCycle(Node head) {

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

    public static void main(String[] args){

        Node head = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        Node node4 = new Node(7);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        printList(head);

        Node newHead = reverse(head);

        printList(newHead);


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


