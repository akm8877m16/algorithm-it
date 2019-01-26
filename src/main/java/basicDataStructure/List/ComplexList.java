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
        /**
         * 三步走的思路 其实可以搞嵌套
         */
        ComplexListNode temp = addNode(root);
        temp = addSibling(temp);
        temp = listSplit(temp);
        return temp;
    }

    /**
     * 第一步: 复制node, 在原来的链表上逐个复制，然后挂到原结点后面
     * @param root
     * @return
     */
    private static ComplexListNode addNode(ComplexListNode root){
        if(root == null){
            return null;
        }
        ComplexListNode temp = root;
        ComplexListNode temp2;
        while (temp != null){
            ComplexListNode newNode = new ComplexListNode(temp.val);
            temp2 = temp.next; // 临时存一下下一个引用，因为要加复制的node
            temp.next = newNode;
            newNode.next = temp2;
            temp = temp2;
        }
        return root;
    }

    /**
     * 第二步: 复制 sibling
     * @param root
     * @return
     */
    private static ComplexListNode addSibling(ComplexListNode root){
        if(root == null){
            return null;
        }
        /**
         * 此时 偶数位置为原来的结点，奇数位置为新复制的节点, 对应的sibling 节点往后移动一个位置即可
         */
        int index = 0;
        ComplexListNode temp = root;
        ComplexListNode sibling = null;
        while(temp != null){
            if(index %2 ==0){
                sibling = temp.sibling;
            }else{
                if(sibling !=null){
                    temp.sibling = sibling.next;
                }
            }
            temp = temp.next;
            index++;
        }
        return root;
    }

    /**
     * 第三步： 拆分list 按照index 奇数偶数标识来拆
     * @param root 返回复制后的list,同时，原来的list恢复原状
     * @return
     */
    private static ComplexListNode listSplit(ComplexListNode root){
        if(root == null){
            return null;
        }
        ComplexListNode newRoot = null; //用来保存复制的链表的头
        int index = 0;
        ComplexListNode temp = root;    // 这个用来遍历
        ComplexListNode temp2;  //这样命名不好记住含义，先凑合
        ComplexListNode temp3 = null;
        while(temp != null){
                /** 目前位置是原来的节点  一边画图一边写，还是能搞得比较清楚 */
                 temp2 = temp.next; //这是对应的复制节点
                 if(newRoot == null){
                     newRoot = temp2; //初始化复制链表的头节点
                     temp3 = temp2;
                 }else{
                     temp3.next = temp2;
                     temp3 = temp2;
                 }
                 temp.next = temp2.next;
                 temp = temp.next;

        }
        temp3.next = null;
        return newRoot;
    }

    public static void printComplexList(ComplexListNode root){
        if(root == null){
            return;
        }
        System.out.println("print start");
        ComplexListNode temp = root;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("print end");
    }


    public static ComplexListNode clone2(ComplexListNode root){
        return null;
    }


    public static class ComplexListNode{

        int val;
        ComplexListNode next;
        ComplexListNode sibling; //这个指针可以指向链表中任意一个节点，或者是null

        ComplexListNode(int value){
            val = value;
        }

        @Override
        public String toString() {
            return "current value: "+ val + " next value: " +
                    (next == null? "null": String.valueOf(next.val)) +
                    " sibling value: " + (sibling == null? "null":String.valueOf(sibling.val));
        }
    }

    public static void main(String[] args){

        ComplexListNode root = new ComplexListNode(10);
        ComplexListNode node1 = new ComplexListNode(9);
        ComplexListNode node2 = new ComplexListNode(7);
        ComplexListNode node3 = new ComplexListNode(6);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;

        root.sibling = node1;
        node1.sibling = node3;
        node3.sibling = node2;

        printComplexList(root);
        ComplexListNode copyRoot = clone(root);
        printComplexList(copyRoot);
        printComplexList(root);
    }

}
