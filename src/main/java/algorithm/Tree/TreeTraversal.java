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
     * 前序遍历 一个linkedList(同广度遍历) + 辅助栈
     * @param head
     */
    public static void preOrder(TreeNode head){
        if(head == null){
            return;
        }
        LinkedList<TreeNode> leftList = new LinkedList<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftList.add(head);
        while(!leftList.isEmpty()){
            TreeNode temp = leftList.pop();
            System.out.println(temp.val);
            if(temp.left != null){
                leftList.add(temp.left);
            }
            if(temp.right != null){
                rightStack.add((temp.right));
            }
            if(leftList.isEmpty()){
                while(!rightStack.isEmpty()){
                    leftList.add(rightStack.pop());
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void inOrder(TreeNode head){


    }

    /**
     * 后序遍历
     * @param head
     */
    public static void postOrder(TreeNode head){


    }


}