package algorithm.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树路径概念: 一个路径指从根结点到叶子节点所经过的节点形成的路径
 *
 * 剑指Offer 34 输入一个二叉树和一个整数，打印出二叉树中和为该值的所有路径
 */
public class FindPath {

    /**
     * 思路，类似回溯，但递归的规律，没找到还是没法编
     *
     * 而操作上，既然要保留父节点，那么就要存，什么结构存？自然想到栈
     * 其实这个思路和前序遍历类似
     * 实现思路上的递归模式:
     * 如果value为5, root 值为1，那么就是从root的左节点或者右节点为根开始找路径，路径和为4，
     * 这就是思路，然后，因为是先从左节点找然后再从右节点找，所以每次递归完成需要路径返回父节点，这个回溯利用stack实现
     *
     * @param root
     * @param value
     */
    public static void findPath(TreeNode root, int value){

        if(root == null){
            return;
        }
        /** 其实为了方便打印，可以用双端队列，既可以从头遍历也可以当栈使用  */
        LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        findPath(root, value, path,0);
    }



    private static void findPath(TreeNode root, int expectedValue, LinkedList<TreeNode> path, int currentValue){

        path.add(root);
        int sum = currentValue + root.val;
        if(isLeaf(root) && sum == expectedValue){
            /** 符合条件的路径  */
            printPath(path);
        }else{

        }




    }

    private static void printPath(LinkedList<TreeNode> list){
        Iterator<TreeNode> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next().val);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 判断是否是叶子节点
     * @param node
     * @return
     */
    private static boolean isLeaf(TreeNode node){

        return node.left == null && node.right == null;

    }


    public static void main(String[] args){


    }

}
