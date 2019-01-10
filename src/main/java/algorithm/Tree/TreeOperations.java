package algorithm.Tree;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static algorithm.Tree.TreeTraversal.preOrder;

public class TreeOperations {

    /**
     * 剑指Offer 面试题 26: 输入两颗二叉数A和B， 判断B是不是A的子结构
     *
     * 解决思路是:递归,而且这里要用两个递归，理解为什么
     * 终止条件是任意一个数判断到叶子节点
     *
     * 此外注意一个细节，这个用的TreeNode存的值是int类型，如果是double呢？不能直接做值比较的
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    public static boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2){

        if(pRoot1 == null && pRoot2 != null){
            return false;
        }
        if(pRoot1 != null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        boolean result = false;
        if(pRoot1.val == pRoot2.val){
            /** 根节点相同，要比较左右子树 */
            result = checkIfHasSubtree(pRoot1,pRoot2);
        }
        if(!result){
            result = hasSubtree(pRoot1.left,pRoot2);
        }
        if(!result){
            result = hasSubtree(pRoot1.right,pRoot2);
        }

        return result;
    }

    private static boolean checkIfHasSubtree(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 != null){
            return false;
        }
        if(pRoot1 != null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        if(pRoot1.val != pRoot2.val){
            return false;
        }
        return checkIfHasSubtree(pRoot1.left,pRoot2.left)&&checkIfHasSubtree(pRoot1.right,pRoot2.right);
    }


    /**
     * 剑指Offer 面试题27: 二叉树镜像
     * 输入一个二叉树，该函数输出它的镜像。
     *
     * 处理递归，思考一下非递归怎么搞？
     *
     * 思路: 遍历交换左右节点
     * @param head
     */
    public static void mirrorTree(TreeNode head){
        /** 非递归，考虑如何利用前序遍历的思路，谦虚是根左右，正好可以遍历时交换左右节点 */

        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        TreeNode temp;
        /**利用前序遍历, 此外空的位置，*/
        while(!stack.isEmpty()){
            TreeNode node =stack.pop();
            if(node.left != null || node.right != null){
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

        return;
    }

    /**
     * 剑指Offer 面试题28: 对称二叉树
     * 实现一个函数，判断一颗二叉树是不是对称的
     *
     * 思路： 遍历，对称条件:根左右 和 根右左是一样的，要把null位置一起考虑进去
     * @param head
     */
    public static boolean treeIsSymmetrical(TreeNode head){

        if(head == null){
            return true;
        }
        List<TreeNode> list1 = preOrderList(head,true);
        List<TreeNode> list2 = preOrderList(head,false);
        TreeNode temp1;
        TreeNode temp2;
        for(int i=0;i< list1.size();i++){
            temp1 = list1.get(i);
            temp2 = list2.get(i);
            if(temp1 == null && temp2 == null){
                continue;
            }
            if(temp1 == null && temp2 != null){
                return false;
            }
            if(temp2 == null && temp1 != null){
                return false;
            }
            if(temp1.val != temp2.val){
                return false;
            }
        }
        return true;
    }

    /**
     * 返回前序遍历(根左右)或者根右左遍历的树节点列表，包含null, 那也就是返回完整的二叉树结构
     * @param head
     * @param isPre  true 根左右  false 根右左
     * @return
     */
    public static List<TreeNode> preOrderList(TreeNode head,boolean isPre){

        if(head == null){
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        /** 这里有一个问题，null要放入的话，怎么判断遍历结束了 */
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node);
            /** 叶子节点，不需要继续了，否则list中多加Null，没有意义 */
            if(node==null){
                continue;
            }
            if(isPre){
                stack.push(node.right);
                stack.push(node.left);
            }else{
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return list;
    }

    public static void printListWithNull(List<TreeNode> list){
        if(list == null || list.size() ==0){
            return;
        }
        TreeNode node;
        for(int i=0;i<list.size();i++){
            node = list.get(i);
            if(node == null){
                System.out.print("null ");
            }else{
                System.out.print(node.val + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args){

        /*
        TreeNode pHead = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        TreeNode p7 = new TreeNode(7);

        pHead.left = p2;
        pHead.right = p3;
        p2.left = p5;
        p2.right = p6;
        p3.left = p8;
        p3.right = p9;
        p5.left = p7;

        TreeNode subTreeHead1 = new TreeNode(3);
        TreeNode subTree8 = new TreeNode(85);
        TreeNode subTree9 = new TreeNode(9);
        subTreeHead1.left = subTree8;
        subTreeHead1.right = subTree9;

        TreeNode subTreeHead2 = new TreeNode(3);

        TreeNode subTreeHead3 = new TreeNode(2);
        TreeNode subTree35 = new TreeNode(5);
        TreeNode subTree37 = new TreeNode(17);
        subTreeHead3.left = subTree35;
        subTree35.left = subTree37;


        boolean result = hasSubtree(pHead,p2);
        System.out.println(result);

        boolean result2 = hasSubtree(pHead,subTreeHead1);
        System.out.println(result2);

        boolean result3 = hasSubtree(pHead,subTreeHead2);
        System.out.println(result3);

        boolean result4 = hasSubtree(pHead,subTreeHead3);
        System.out.println(result4);
        */

        /*
        TreeNode head = new TreeNode(7);
        //TreeNode node8 = new TreeNode(8);
        //TreeNode node9 = new TreeNode(9);
        //TreeNode node10 = new TreeNode(10);
        //TreeNode node11 = new TreeNode(11);
        //head.left = node8;
        //head.right = node9;
        //node8.left = node10;
        //node8.right = node11;

        preOrder(head);
        mirrorTree(head);
        preOrder(head);
        */

        /** 这个测试表明，叶子节点也要考虑  */
        TreeNode head = new TreeNode(7);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(7);
        TreeNode node10 = new TreeNode(7);
        TreeNode node11 = new TreeNode(7);



        head.left = node8;
        head.right = node9;
        node8.left = node10;
        node8.right = node11;



        boolean result = treeIsSymmetrical(head);
        System.out.println(result);
        printListWithNull(preOrderList(head,true));
        printListWithNull(preOrderList(head,false));
    }


}
