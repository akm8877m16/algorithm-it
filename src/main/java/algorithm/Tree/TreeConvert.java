package algorithm.Tree;


import sun.reflect.generics.tree.Tree;

/**
 * 剑指Offer 36
 * 二叉搜索树转成一个排序的双向链表，不能创建任何新的节点，只能调整树中节点的指向
 */
public class TreeConvert {

    /**
     * 思路让人想到中序遍历，但其实有区别，按照中序遍历的思路，反而会发现解决很复杂
     * 实际上还是分治的思路: 根作为一个节点，它的前节点就是左子树转成的双向链表的尾节点，
     * 它的后节点是右子树转成的双向链表的头结点
     *
     * TreeNode 可以直接作为双向链表节点，做个定义:
     * left 左  前
     * right 右 后
     *
     * @param root
     * @return
     */
    public static TreeNode convertList(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode leftHead = null;  //左子树转成的队列
        TreeNode  rightHead = null; //右子树转成的队列
        if(root.left != null){
            leftHead = convertList(root.left);
        }
        if(root.right != null){
            rightHead = convertList(root.right);
        }
        if(leftHead == null && rightHead == null){
            root.right = null;
            root.left = null;
            return root;
        }
        if(leftHead == null && rightHead != null){
            /** 前节点没有，后节点有 */
            root.right = rightHead;
            rightHead.left = root;
            root.left = null;
            return root;
        }
        if(leftHead != null && rightHead == null){
            root.right = null;
            TreeNode temp = leftHead;
            while(temp != null){
                if(temp.right != null){
                    temp = temp.right;
                }else{
                    break;
                }
            }
            root.left = temp;
            temp.right = root;
            return leftHead;
        }

        root.right = rightHead;
        rightHead.left = root;
        TreeNode temp = leftHead;
        while(temp != null){
            if(temp.right != null){
                temp = temp.right;
            }else{
                break;
            }
        }
        root.left = temp;
        temp.right = root;
        return leftHead;

    }

    /**
     * 打印双端链表
     * @param head
     */
    public static void printDoubleList(TreeNode head){

        /** 不妨打一圈 */
        if(head == null){
            return;
        }
        TreeNode temp = head;
        while(temp != null){
            System.out.print(temp.val);
            System.out.print(" ");
            if(temp.right != null){
                temp = temp.right;
            }else{
                //尾部节点
                break;
            }
        }
        temp = temp.left;
        while(temp != null){
            System.out.print(temp.val);
            System.out.print(" ");
            temp = temp.left;
        }
        System.out.println();
    }

    public static void main(String[] args){

        /** 测试用例，最简单的开始 */
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        //root.left = node1;
        root.right = node2;                  //这里暴露了问题,已经改了，注意不要前后的引用节点都要设置
        TreeNode listHead = convertList(root);
        printDoubleList(listHead);


        TreeNode root2 = new TreeNode(7);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(8);
        TreeNode node23 = new TreeNode(1);
        TreeNode node24 = new TreeNode(5);
        TreeNode node25 = new TreeNode(20);

        root2.left = node21;
        root2.right = node22;
        node21.left = node23;
        node21.right = node24;
        node22.right = node25;

        TreeNode listHead2 = convertList(root2);
        printDoubleList(listHead2);
    }

}
