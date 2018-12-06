/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package basicDataStructure.List;

/**
 *  ����Ļ�������
 *
 *
 * @author wb-ywh474663
 * @version $Id: ListOperations.java, v 0.1 2018��11��27�� 22:52 wb-ywh474663 Exp $
 */
public class ListOperations {

    /**
     * ֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static Node mergeOrderLists(Node pHead1, Node pHead2){
        return null;


    }

    /**
     * �ж������������Ƿ��ཻ
     */
    public static boolean isIntersect(Node head1, Node head2){
        return false;

    }

    /**
     * �������������ཻ�ĵ�һ���ڵ�
     */
    public static Node getFirstCommonNode(Node head1, Node head2) {

        return null;

    }

    /**
     * �ж�һ�����������Ƿ��л�
     */
    public static boolean hasCycle(Node head) {

        return false;

    }

    /**
     *����뻷�еĵ�һ���ڵ�
     */
    public static Node getFirstNodeInCycle(Node head) {

        return null;


    }

    /**
     *  ����һ������ͷָ��pHead��һ�ڵ�ָ��pToBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�pToBeDeleted: delete
     */
    public static void delete(Node head, Node toDelete){


    }


        /**
             * ����ת
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

// ��������ṹ�� val��next
class Node {

    int  val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}


