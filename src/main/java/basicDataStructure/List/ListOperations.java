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
     * ��β��ͷ��ӡ����
     * ��Ȼ�뵽��ջ����ջ��Ȼ�뵽�õݹ飬������ȷҪ���õݹ飬��Ȼջ��³���Ժ�
     * @param head
     */
    public static void printReverse(Node head){


    }

    /**
     * ��ָOffer ������25:
     * ע��³���ԣ������Ա�̵�ϰ��Ҫ����
     * ֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static Node mergeOrderLists(Node pHead1, Node pHead2){
        //ע��߽�����
        if(pHead1 == null && pHead2 == null){
            return null;
        }else if(pHead1 == null && pHead2 != null){
            return pHead2;
        }else if(pHead1 != null && pHead2 == null){
            return pHead1;
        }else{
            Node mergeHead;
            Node temp;
            //����������Ϊ�գ�
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
     * �ж������������Ƿ��ཻ
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
     * �������������ཻ�ĵ�һ���ڵ�
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
     * �ж�һ�����������Ƿ��л�, ����ָ��
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
        //�л��Ļ����߼������߲���β���ģ���Ϊû��β�����ǻ�
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
     * �ж�һ�����������Ƿ��л�, ����ָ�룬����л������ؿ���ָ���һ��������
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
        //�л��Ļ����߼������߲���β���ģ���Ϊû��β�����ǻ�
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
     * ��ָOffer ������23��
     * ���е�˼·����һЩ��ͬ��ȷ�ϻ����ں���������ĳ���n��Ȼ������ָ��
     * ��n�ƶ��������ĵ���ǻ���ڣ������鷳�ˣ�
     *
     * ��ʵ���Է��֣��������n���ڵ㣬������m���ڵ㣬��ڲ�����m-n��Ӧ�Ľڵ��
     * ����Ҫm��֪��������һ���ֲ����㣬���Բ�����ô��
     *
     * ����뻷�еĵ�һ���ڵ�
     * �߼����ǿ��Եģ����ǿ���˼����������С��������������Ԥ��һ�飬���������������˼·
     */
    public static Node getFirstNodeInCycle(Node head) {

        //����Ҫȷ����û�л����������������ǰ��Ӧ�����л��ģ���û��ҲҪ�ܴ���
        Node circle =  getCircleNode(head);
        if(circle == null){
            return null;
        }
        Node start = head;
        //�Ѿ��ж��л���
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
     *  ����һ������ͷָ��pHead��һ�ڵ�ָ��pToBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�pToBeDeleted: delete
     *  ����д��ʵ����������Ϊ���ֱ߽����û�п��ǵ�
     *  1 ֻ��һ���ڵ㣬head == toDelete
     *  2 toDelete��β�ڵ㣬���ʱ��ֻ�ܴ�ͷ����
     */
    public static void delete(Node head, Node toDelete){
            //���Ǹ�˼ά���壬��ʵɾ�Ĳ�������ڵ㱾��������һ����㣬�Ѻ����ֵ���Ƶ�Ҫɾ���ڵ���
            Node next = toDelete.next;
            toDelete.val = next.val;
            toDelete.next = next.next;
    }


    /**
     * ��ָOffer ������ 24�� ����ת
     * 2019/01/
     * ����Ҫ���¼��һ��³����
     *
     * ���⣬�ݹ��˼·Ҳдһ��
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
     * ��ȡĳ������ĳ��ȣ� ע�ⲻҪ�ı�����ͷ��ָ��
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
     * ɾ�������������ظ��Ľڵ�
     * ���� 1-2-3-3-4-4-5
     * ɾ������ 1-2-5
     *
     * ˼·�� ����1: ���node1.val != node2.val, ��ôdeleteDuplicate(node1) ����deleteDuplicate(node2)
     *       ����2: ���node1.val == node2.val���Ǿ�Ҫ�����ҵ���������1�����
     * @param head
     * @return
     */
    public static Node deleteDuplicate(Node head){
        /** ������ */
        if(head == null){
            return null;
        }
        /** �����ڵ����� */
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
     * ��ָOffer 22�⣺ �����е�����k���ڵ� k��1��ʼ��
     * ע�⼸�㣺 1 ³����
     *          2 ����ֻ�ܱ���һ�飬��ôʵ�֣�ʹ������ָ�룬���˼·�ܳ���
     *
     * @param head
     * @return
     */
    public static Node findKthToTail(Node head){

        return null;

    }

    /**
     * ��������м�ڵ㣬��������еĽڵ��������������򷵻��м�ڵ㣬����ڵ�������ż�����򷵻��м������ڵ��е�����һ��
     * ˼·ͬ��������ָ�����
     * ע��³����
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
        System.out.println("��һ���ཻ���Ϊ:" + intersectNode.val);
        Boolean isCircle = hasCycle(headCircle);
        System.out.println("�Ƿ��ཻ:" + isCircle);
        Node firstCircleNode = getFirstNodeInCycle(headCircle);
        System.out.println("����һ���ڵ㣺" + firstCircleNode.val);


        delete(head,node3);
        printList(head);
        */



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


