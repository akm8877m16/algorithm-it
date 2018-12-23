/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.Tree;

import java.util.Stack;

/** ��ָoffer������8  �ҳ�����������һ���ڵ�
 * Ҫ���ҳ���������е���һ���ڵ㣬����ڵ��и��ڵ�ָ��
 *
 * ������չһ�£�����ǰ������Ļ�������ô�ң� �����أ�
 * �ؼ������������Ҫ���ǵ�
 * @author wb-ywh474663
 * @version $Id: FindNextNode.java, v 0.1 2018��12��12�� 22:33 wb-ywh474663 Exp $
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
     * ��ǰ���������һ�����
     * 1 node ����ڵ㣬������ڵ�
     * 2 node û����ڵ㣬�����ҽڵ㣬�����ҽڵ�
     * 3 node ��Ҷ�ӽڵ㣬�Ǹ��ڵ����ڵ㣬���ڵ����ҽڵ�,�����ҽڵ�
     * 4 node ��Ҷ�ӽڵ㣬�Ǹ��ڵ����ڵ㣬���ڵ�û���ҽڵ㣬���Ҹ��ڵ��һ�����ڵ㣬Ҫ��ǰһ�����ڵ���������ڵ�
     *        ����ڵ㣬����������ڵ����ҽڵ㣬��������ҽڵ㣬һֱ���ݵ����ڵ㣬������������ֹ
     * 5 node ��Ҷ�ӽڵ㣬�Ǹ��ڵ���ҽڵ㣬�����4��ͬ
     * ����һ�£�
     * ֻ�жԱ�����Ϥ���ܷ�������
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
        //��������
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