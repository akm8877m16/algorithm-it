package basicDataStructure.List;


/**
 * 剑指Offer 35 复杂链表的复制
 *
 *
 */
public class ComplexList {

    /**
     * 两种思路，优化sibling的查找时间，都做一下
     * @param root
     * @return
     */
    public static ComplexListNode clone(ComplexListNode root){

        return null;
    }


    public static class ComplexListNode{

        int val;
        ComplexListNode next;
        ComplexListNode sibling; //这个指针可以指向链表中任意一个节点，或者是null

        ComplexListNode(int value){
            val = value;
        }
    }

    public static void main(String[] args){


    }

}
