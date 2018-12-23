/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.Tree;

import java.util.Stack;

/** 剑指offer面试题8  找出二叉树的下一个节点
 * 要求找出中序遍历中的下一个节点，假设节点有父节点指针
 *
 * 这题扩展一下，假设前序遍历的话可以怎么找？ 后序呢？
 * 关键是所有情况都要考虑到
 * @author wb-ywh474663
 * @version $Id: FindNextNode.java, v 0.1 2018年12月12日 22:33 wb-ywh474663 Exp $
 */
public class FindNextNode {

    public static class TreeNodeTriple{
            int val;
            TreeNodeTriple left;
            TreeNodeTriple right;
            TreeNodeTriple parent;

            public TreeNodeTriple(int val){
                this.val = val;
            }
    }


    public static TreeNodeTriple findNodeInOrder(TreeNodeTriple node){
        return null;
    }

    /**
     * 找前序遍历的下一个结点
     * 1 node 有左节点，就是左节点
     * 2 node 没有左节点，但有右节点，就是右节点
     * 3 node 是叶子节点，是父节点的左节点，父节点有右节点,就是右节点
     * 4 node 是叶子节点，是父节点的左节点，父节点没有右节点，则找父节点的一个父节点，要求前一个父节点是这个父节点
     *        的左节点，并且这个父节点有右节点，就是这个右节点，一直回溯到根节点，不满足条件终止
     * 5 node 是叶子节点，是父节点的右节点，步骤和4相同
     * 测试一下，
     * 只有对遍历熟悉才能分清楚情况
     * @param node
     * @return
     */
    public static TreeNodeTriple findNodePreOrder(TreeNodeTriple node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            return node.left;
        }
        if(node.right != null){
            return node.right;
        }
        //根结点情况
        if(node.parent == null){
            return null;
        }
        TreeNodeTriple parent = node.parent;
        if(parent.left == node){
            if(parent.right != null) {
                return parent.right;
            }
        }
        while(parent.parent!=null){
            TreeNodeTriple grandParent = parent.parent;
            if(grandParent.left == parent && grandParent.right != null){
                    return grandParent.right;
            }
            parent = grandParent;
        }
        return null;
    }

    public static void preOrder(TreeNodeTriple head){
        if(head == null){
            return;
        }
        Stack<TreeNodeTriple> stack = new Stack<TreeNodeTriple>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNodeTriple node = stack.pop();
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


    public static void main(String[] args){

        TreeNodeTriple head = new TreeNodeTriple(1);
        TreeNodeTriple node1 = new TreeNodeTriple(2);
        TreeNodeTriple node2 = new TreeNodeTriple(3);
        TreeNodeTriple node3 = new TreeNodeTriple(4);
        TreeNodeTriple node4 = new TreeNodeTriple(5);
        TreeNodeTriple node5 = new TreeNodeTriple(6);
        TreeNodeTriple node6 = new TreeNodeTriple(7);
        TreeNodeTriple node7 = new TreeNodeTriple(8);
        TreeNodeTriple node8 = new TreeNodeTriple(8);
        TreeNodeTriple node9 = new TreeNodeTriple(7);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node1.parent = head;

        node2.left = node5;
        node2.parent = head;

        node3.left = node6;
        node3.right = node7;
        node3.parent = node1;
        node4.parent = node1;
        node5.left = node8;
        node5.parent = node2;
        node6.parent = node3;
        node7.parent = node3;
        node8.parent = node5;

        //node2.right = node9;
        preOrder(head);

        TreeNodeTriple result = findNodePreOrder(node1);
        if(result != null){
            System.out.println(node1.val+" next value:" + result.val);
        }else{
            System.out.println("no next value, it's the end");
        }
        result = findNodePreOrder(node3);
        if(result != null){
            System.out.println(node3.val+" next value:" + result.val);
        }else{
            System.out.println("no next value, it's the end");
        }
        result = findNodePreOrder(node7);
        if(result != null){
            System.out.println(node7.val+" next value:" + result.val);
        }else{
            System.out.println("no next value, it's the end");
        }result = findNodePreOrder(node8);
        if(result != null){
            System.out.println(node8.val+" next value:" + result.val);
        }else{
            System.out.println("no next value, it's the end");
        }

    }



}