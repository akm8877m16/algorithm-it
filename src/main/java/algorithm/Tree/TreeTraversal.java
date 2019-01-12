/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树三种遍历，递归就不搞了，太简单
 * 回忆一下前序，中序， 后序三种遍历
 * 因为目前还要做反过来的题目，比如从遍历结构做
 * @author wb-ywh474663
 * @version $Id: TreeTraversal.java, v 0.1 2018年12月11日 10:54 wb-ywh474663 Exp $
 */
public class TreeTraversal {

    /**
     * 前序遍历 一个linkedList(同广度遍历) + 辅助栈,但这么搞想复杂了
     * 其实一个栈就够了：
     * @param head
     */
    public static void preOrder(TreeNode head){
        if(head == null){
            return;
        }
       Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
            System.out.print(node.val);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 这个不是前序遍历，但其实很像，这个遍历顺序是根右左
     * @param head
     */
    public static void preOrderRight(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            System.out.print(node.val);
            System.out.print(" ");
        }
        System.out.println();


    }

    /** 先遍历left到底，然后搞right
     * 中序遍历
     * @param head
     */
    public static void inOrder(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        TreeNode cur = head;
        while(!stack.isEmpty()){

            while(cur.left != null){
                stack.add(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val);
            System.out.print(" ");
            if(cur.right != null){
                cur = cur.right;
                stack.add(cur);
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历 很容易和中序搞混
     * @param head
     */
    public static void postOrder(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> inputStack = new Stack<TreeNode>();
        stack.add(head);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            inputStack.add(node);
        }
        while(!inputStack.isEmpty()){
            System.out.print(inputStack.pop().val);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 剑指Offer 32 从上到下打印二叉树
     * 就是广度优先遍历
     *
     * 解决思路就是利用队列 实现分层
     *
     * 扩展思考： 如何广度优先遍历有向图，类似的思路
     * @param head
     */
    public static void printFromTopToBottom(TreeNode head){

        return;
    }


    /**
     * 作为上题的一个小变形，要求分行打印广度遍历二叉树
     *
     * 思路是一样的，就是要考虑如何判断一行结束
     * @param head
     */
    public static void printFromTopToBottomInLines(TreeNode head){

        return;
    }

    /**
     * 再在上一题的基础上做一些改变，要求分行打印广度遍历二叉树，而且，要求实现之字形打印二叉树，即
     * 第一层从左到右打印，第二层从右到左打印，第三层从左到右打印，以此类推
     * @param head
     */
    public static void printFromTopToBottomInLines2(TreeNode head){

        return;
    }


    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        head.left = node1;
        head.right = node2;

        node1.left = node3;
        node1.right = node4;

        preOrder(head);
        inOrder(head);
        postOrder(head);

    }


}